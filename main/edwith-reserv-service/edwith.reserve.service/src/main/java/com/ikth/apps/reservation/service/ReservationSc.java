package com.ikth.apps.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ikth.apps.reservation.dao.ReservationDao;
import com.ikth.apps.reservation.dto.Category;
import com.ikth.apps.reservation.dto.DisplayInfoResponse;
import com.ikth.apps.reservation.dto.Product;
import com.ikth.apps.reservation.dto.ProductResponse;

@Profile("!BwG")
@Service
public class ReservationSc implements IReservationSc
{
	@Autowired
	private ReservationDao reservationDao;

	public List<Category> getAllCategories() {
		return reservationDao.getAllCategories();
	}
	
	public ProductResponse getPromotionedProducts() {
		List<Product> promotioned= reservationDao.getPromotionedProducts();
		
		ProductResponse response= new ProductResponse();
		response.setItems(promotioned);
		response.setTotalCount(promotioned.size());
		
		return response;
	}
	
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
		// TODO Auto-generated method stub
		return null;
	}
}
