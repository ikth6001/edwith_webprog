package com.ikth.apps.reservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ikth.apps.reservation.dto.Category;
import com.ikth.apps.reservation.dto.Product;
import com.ikth.apps.reservation.dto.ProductResponse;

@Profile("BwG")
@Service
public class ReservationMockSc implements IReservationSc
{

	@Override
	public List<Category> getAllCategories() 
	{
		List<Category> categories= new ArrayList<>();
		
		{
			Category category= new Category();
			category.setName("테스트 A");
			category.setId(1);
			categories.add(category);
		}
		
		{
			Category category= new Category();
			category.setName("테스트 B");
			category.setId(2);
			categories.add(category);
		}
		
		return categories;
	}

	@Override
	public ProductResponse getPromotionedProducts() 
	{
		Product p= new Product();
		p.setDisplayInfoId(1);
		p.setPlaceName("BwG");
		p.setProductContent("This is a mock data for test");
		p.setProductDescription("test");
		p.setProductId(1);
		p.setProductImageUrl("/img/test.png");
		
		List<Product> mock= new ArrayList<>();
		mock.add(p);
		
		ProductResponse response= new ProductResponse();
		response.setItems(mock);
		response.setTotalCount(1);
		
		return response;
	}

	@Override
	public ProductResponse getProducts(int categoryId, int start) 
	{
		Product p= new Product();
		p.setDisplayInfoId(1);
		p.setPlaceName("BwG");
		p.setProductContent("This is a mock data for test");
		p.setProductDescription("test");
		p.setProductId(1);
		p.setProductImageUrl("/img/test.png");
		
		List<Product> mock= new ArrayList<>();
		mock.add(p);
		
		ProductResponse response= new ProductResponse();
		response.setItems(mock);
		response.setTotalCount(1);
		
		return response;
	}
}
