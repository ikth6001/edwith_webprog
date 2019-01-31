package com.ikth.apps.reserve.product.service;

import java.util.List;

import com.ikth.apps.reserve.product.vo.ProductVO;

public interface IProductSc 
{
	List<ProductVO> getProducts(String code, int cnt);

	List<ProductVO> getPromotionedProducts();
	
	int getProductCnt(String code);
}
