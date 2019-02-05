package com.ikth.apps.reservation.product.service;

import java.util.List;

import com.ikth.apps.reservation.dto.ProductVO;

public interface IProductSc 
{
	List<ProductVO> getProducts(String code, int cnt);

	List<ProductVO> getPromotionedProducts();
	
	int getProductCnt(String code);
}
