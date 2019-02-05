package com.ikth.apps.reservation.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.ikth.apps.reservation.dto.Category;
import com.ikth.apps.reservation.dto.Product;

@Component
@Profile("BwG")
public class MockDataReservationDao implements ReservationDao 
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
	public List<Product> getPromotionedProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProducts(int categoryId, int start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getProductCount(int categoryId) {
		// TODO Auto-generated method stub
		return 0;
	}
}