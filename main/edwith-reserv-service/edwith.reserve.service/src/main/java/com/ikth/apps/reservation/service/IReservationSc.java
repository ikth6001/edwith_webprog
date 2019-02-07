package com.ikth.apps.reservation.service;

import java.util.List;

import com.ikth.apps.reservation.dto.Category;
import com.ikth.apps.reservation.dto.ProductResponse;

public interface IReservationSc {
	
	List<Category> getAllCategories();
	
	ProductResponse getPromotionedProducts();
	
	ProductResponse getProducts(int categoryId, int start);

}
