package com.ikth.apps.reserve.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ikth.apps.reserve.product.constants.ProductConstants;
import com.ikth.apps.reserve.product.dao.ProductDao;
import com.ikth.apps.reserve.product.vo.ProductVO;

@Service("productSc")
@Profile("HoMe")
public class ProductSc implements IProductSc
{
	@Autowired
	ProductDao productDao;

	@Override
	public List<ProductVO> getPromotionedProducts() 
	{
		return productDao.selectPromotionedProducts();
	}

	@Override
	public List<ProductVO> getProducts(String code, int cnt) 
	{
		if(ProductConstants.CODE_ALL.equals(code)) {
			return productDao.selectProducts(cnt);
		} else {
			return productDao.selectProductsByCode(code, cnt);
		}
	}

	@Override
	public int getProductCnt(String code) 
	{
		return productDao.selectCountProducts(
					ProductConstants.CODE_ALL.equals(code) ? null : code);
	}
}