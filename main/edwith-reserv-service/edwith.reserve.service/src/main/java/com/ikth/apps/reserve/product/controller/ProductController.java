package com.ikth.apps.reserve.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ikth.apps.reserve.product.service.IProductSc;
import com.ikth.apps.reserve.product.vo.ProductVO;

@RestController
public class ProductController 
{
	@Autowired
	private IProductSc productSc; 
	
	@RequestMapping(method= RequestMethod.GET, value= "/api/promotioned")
	public List<ProductVO> getPromotionedProducts()
	{
		return productSc.getPromotionedProducts();
	}
	
	@RequestMapping(method= RequestMethod.GET, value= "/api/products/{code}/{cnt}")
	public List<ProductVO> getProducts(@PathVariable String code, @PathVariable int cnt)
	{
		return productSc.getProducts(code, cnt);
	}
	
	@RequestMapping(method= RequestMethod.GET, value= "/api/count/{code}")
	public int getProductsCnt(@PathVariable String code)
	{
		return productSc.getProductCnt(code);
	}
}
