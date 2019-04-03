package com.ikth.apps.reservation.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ikth.apps.reservation.dao.ReservationDao;
import com.ikth.apps.reservation.dto.Category;
import com.ikth.apps.reservation.dto.Comment;
import com.ikth.apps.reservation.dto.DisplayInfo;
import com.ikth.apps.reservation.dto.DisplayInfoImage;
import com.ikth.apps.reservation.dto.DisplayInfoResponse;
import com.ikth.apps.reservation.dto.Product;
import com.ikth.apps.reservation.dto.ProductImage;
import com.ikth.apps.reservation.dto.ProductPrice;
import com.ikth.apps.reservation.dto.ProductResponse;
import com.ikth.apps.reservation.dto.ReservationInfo;
import com.ikth.apps.reservation.dto.ReservationInfoResponse;
import com.ikth.apps.reservation.dto.ReservationParam;
import com.ikth.apps.reservation.dto.ReservationPrice;

@Service
public class ReservationSc implements IReservationSc
{
	private final static org.slf4j.Logger logger= LoggerFactory.getLogger(ReservationSc.class);
	
	@Autowired
	private ReservationDao reservationDao;

	@Override
	public List<Category> getAllCategories() {
		return reservationDao.getAllCategories();
	}
	
	@Override
	public ProductResponse getPromotionedProducts() {
		List<Product> promotioned= reservationDao.getPromotionedProducts();
		
		ProductResponse response= new ProductResponse();
		response.setItems(promotioned);
		response.setTotalCount(promotioned.size());
		
		return response;
	}
	
	@Override
	public ProductResponse getProducts(int categoryId, int start) {
		List<Product> items= reservationDao.getProducts(categoryId, start);
		int categoryCnt= reservationDao.getProductCount(categoryId);
		
		ProductResponse response= new ProductResponse();
		response.setItems(items);
		response.setTotalCount(categoryCnt);
		
		return response;
	}

	@Override
	public DisplayInfoResponse getDisplayInfo(int displayInfoId) {
		DisplayInfoResponse response= new DisplayInfoResponse();

		DisplayInfo displayInfo= reservationDao.getDisplayInfo(displayInfoId);
		if(displayInfo == null) {
			/**
			 * TODO 예외 처리를 어떤 식으로 할지에 대한 결정 미정
			 */
			return null;
		}
		
		response.setDisplayInfo(displayInfo);
		
		final int productId= displayInfo.getProductId();
		List<Comment> comments= reservationDao.getComments(productId);
		response.setComments(comments);
		response.setAverageScore(getAvgScore(comments));
		
		DisplayInfoImage displayInfoImage= reservationDao.getDisplayInfoImage(displayInfoId);
		response.setDisplayInfoImage(displayInfoImage);
		
		List<ProductImage> productImages= reservationDao.getProductImages(productId);
		response.setProductImages(productImages);
		
		List<ProductPrice> productPrices= reservationDao.getProductPrices(productId);
		response.setProductPrices(productPrices);
		
		return response;
	}
	
	private double getAvgScore(List<Comment> comments) {
		double score= 0L;
		
		for(Comment comment : comments) {
			score += comment.getScore();
		}
		
		if(comments.size() == 0) {
			return score;
		} else {
			double result= score / comments.size();
			return BigDecimal.valueOf(result).setScale(1, RoundingMode.HALF_UP).doubleValue();
		}
	}

	@Override
	@Transactional
	public boolean reservation(ReservationParam reservationParam) 
	{
		/** product id 관리할 필요 없으니까 일단.. */
		reservationParam.setProductId(reservationParam.getDisplayInfoId());
		int cnt= reservationDao.addReservation(reservationParam);
		
		if(cnt == 1) {
			int id= reservationParam.getId();
			logger.debug("auto incremented reservation id is [{}]", id);
			
			for(ReservationPrice price : reservationParam.getPrices()) {
				price.setReservationInfoId(id);
				reservationDao.addPrice(price);
			}
		} else {
			return false;
		}

		return true;
	}

	@Override
	public ReservationInfoResponse getReservations(String reservationEmail) 
	{
		ReservationInfoResponse response= new ReservationInfoResponse();
		List<ReservationInfo> reservationInfo= reservationDao.getReservations(reservationEmail);
		
		if(reservationInfo == null) {
			return response;
		}

		SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd HH:mm");
		for(ReservationInfo info : reservationInfo) {
			int id= info.getDisplayInfoId();
			DisplayInfo displayInfo= reservationDao.getDisplayInfo(id);
			
			/**
			 * 마땅한 데이터가 없네
			 */
			displayInfo.setOpeningHours(sdf.format(new Date()));
			info.setDisplayInfo(displayInfo);
			response.addReservationsItem(info);
		}
		
		return response;
	}
	
	private final int CANCEL= 1;

	@Override
	public void cancelReservation(int id) 
	{
		reservationDao.updateReservationStatus(id, CANCEL);
	}
}
