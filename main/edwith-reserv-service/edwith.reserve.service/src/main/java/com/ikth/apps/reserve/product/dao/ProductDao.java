package com.ikth.apps.reserve.product.dao;

import java.util.List;

import com.ikth.apps.reserve.product.vo.ProductVO;

public interface ProductDao 
{
	List<ProductVO> selectAllProduct();
	int insertProduct(ProductVO product);
}
