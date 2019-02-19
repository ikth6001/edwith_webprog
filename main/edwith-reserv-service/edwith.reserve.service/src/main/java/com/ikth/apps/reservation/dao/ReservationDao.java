package com.ikth.apps.reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ikth.apps.reservation.dto.Category;
import com.ikth.apps.reservation.dto.Comment;
import com.ikth.apps.reservation.dto.DisplayInfo;
import com.ikth.apps.reservation.dto.DisplayInfoImage;
import com.ikth.apps.reservation.dto.Product;
import com.ikth.apps.reservation.dto.ProductImage;
import com.ikth.apps.reservation.dto.ProductPrice;

public interface ReservationDao 
{
	List<Category> getAllCategories();
	
	List<Product> getPromotionedProducts();
	
	List<Product> getProducts(@Param("categoryId") int categoryId, @Param("start") int start);
	
	int getProductCount(@Param("categoryId") int categoryId);
	
	DisplayInfo getDisplayInfo(@Param("id") int id);
	
	List<Comment> getComments(@Param("productId") int productId);
	
	DisplayInfoImage getDisplayInfoImage(@Param("displayInfoId") int displayInfoId);
	
	List<ProductImage> getProductImages(@Param("productId") int productId);
	
	List<ProductPrice> getProductPrices(@Param("productId") int productId);
}
