package com.ikth.apps.reservation.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class ReservationSc implements IReservationSc
{
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
}
