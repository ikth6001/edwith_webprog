package com.ikth.apps.reserve.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ikth.apps.reserve.product.dao.ProductDao;
import com.ikth.apps.reserve.product.vo.ProductVO;

@Service("productSc")
@Profile("BwG")
public class TstProductSc implements IProductSc
{
	@Autowired
	private ProductDao tstProductDao;

	@Override
	public List<ProductVO> getProducts(String code, int cnt) 
	{
		if("ALL".equals(code)) {
			return tstProductDao.selectProducts(cnt);
		} else {
			return tstProductDao.selectProductsByCode(code, cnt);
		}
	}

	@Override
	public List<ProductVO> getPromotionedProducts() 
	{
		return tstProductDao.selectPromotionedProducts();
	}

	@Override
	public int getProductCnt(String code) 
	{
		return tstProductDao.selectCountProducts(code);
	}
}
