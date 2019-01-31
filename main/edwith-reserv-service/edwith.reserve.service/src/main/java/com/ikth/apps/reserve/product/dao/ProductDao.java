package com.ikth.apps.reserve.product.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ikth.apps.reserve.product.vo.ProductVO;

@Component("productDao")
public interface ProductDao 
{
	List<ProductVO> selectProductsByCode(String code, int cnt);
	
	List<ProductVO> selectProducts(int cnt);
	
	List<ProductVO> selectPromotionedProducts();
	
	int selectCountProduct(String code);
	
	int insertProduct(ProductVO product);
}
