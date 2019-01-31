package com.ikth.apps.reserve.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.ikth.apps.reserve.product.vo.ProductVO;

@Component("productDao")
public interface ProductDao 
{
	List<ProductVO> selectProductsByCode(@Param("code") String code
										 , @Param("cnt") int cnt);
	
	List<ProductVO> selectProducts(@Param("cnt") int cnt);
	
	List<ProductVO> selectPromotionedProducts();
	
	int selectCountProducts(@Param("code") String code);
}
