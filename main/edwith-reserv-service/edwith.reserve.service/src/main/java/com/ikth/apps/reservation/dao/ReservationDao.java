package com.ikth.apps.reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ikth.apps.reservation.dto.Category;
import com.ikth.apps.reservation.dto.Product;

public interface ReservationDao 
{
	List<Category> getAllCategories();
	
	List<Product> getPromotionedProducts();
	
	List<Product> getProducts(@Param("categoryId") int categoryId, @Param("start") int start);
	
	int getProductCount(@Param("categoryId") int categoryId);
}
