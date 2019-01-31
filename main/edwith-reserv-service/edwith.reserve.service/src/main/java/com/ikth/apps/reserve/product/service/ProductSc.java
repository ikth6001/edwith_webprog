package com.ikth.apps.reserve.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ikth.apps.reserve.product.dao.ProductDao;
import com.ikth.apps.reserve.product.vo.ProductVO;

@Service("productSc")
@Profile("HoMe")
public class ProductSc implements IProductSc
{
	@Autowired
	ProductDao productDao;

	@Override
	public List<ProductVO> getPromotionedProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductVO> getProducts(String code, int cnt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getProductCnt(String code) {
		// TODO Auto-generated method stub
		return 0;
	}
}