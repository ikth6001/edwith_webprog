package com.ikth.apps.reservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ikth.apps.reservation.dto.Category;
import com.ikth.apps.reservation.dto.Comment;
import com.ikth.apps.reservation.dto.DisplayInfo;
import com.ikth.apps.reservation.dto.DisplayInfoResponse;
import com.ikth.apps.reservation.dto.Product;
import com.ikth.apps.reservation.dto.ProductImage;
import com.ikth.apps.reservation.dto.ProductPrice;
import com.ikth.apps.reservation.dto.ProductResponse;
import com.ikth.apps.reservation.dto.ProductImage.TypeEnum;

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
		
		{
			Category category= new Category();
			category.setName("테스트 C");
			category.setId(3);
			categories.add(category);
		}
		
		{
			Category category= new Category();
			category.setName("테스트 D");
			category.setId(4);
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
		p.setProductImageUrl("img/1_ma_2.png");
		
		List<Product> mock= new ArrayList<>();
		mock.add(p);
		
		ProductResponse response= new ProductResponse();
		response.setItems(mock);
		response.setTotalCount(mock.size());
		
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
		p.setProductImageUrl("img/1_ma_2.png");
		
		List<Product> mock= new ArrayList<>();
		mock.add(p);
		
		ProductResponse response= new ProductResponse();
		response.setItems(mock);
		response.setTotalCount(mock.size());
		
		return response;
	}

	@Override
	public DisplayInfoResponse getDisplayInfo(int displayInfoId) 
	{
		DisplayInfoResponse response= new DisplayInfoResponse();
		
		response.setAverageScore(2.5d);
		
		List<Comment> comments= new ArrayList<>();
		{
			Comment comm= new Comment();
			comm.setCommentId(1);
			comm.setProductId(1);
			comm.setReservationName("ikth6001");
			comm.setScore(3.0d);
			
			comments.add(comm);
		}
		
		{
			Comment comm= new Comment();
			comm.setCommentId(1);
			comm.setProductId(1);
			comm.setReservationName("iljy6001");
			comm.setScore(2.0d);
			
			comments.add(comm);
		}
		
		response.setComments(comments);
		
		DisplayInfo displayInfo= new DisplayInfo();
		displayInfo.setCategoryId(1);
		displayInfo.setCategoryName("테스트 A");
		displayInfo.setPlaceName("상암 월드컵 경기장");
		displayInfo.productContent("Blah Blah Blah");
		displayInfo.productDescription("BLAH!!");
		displayInfo.setTelephone("010-****-****");
		
		response.setDisplayInfo(displayInfo);
		
		List<ProductImage> imgs= new ArrayList<>();
		{
			ProductImage img= new ProductImage();
			img.setType(TypeEnum.ET);
			img.setContentType("png");
			img.setFileName("img/10_et_29.png");
			imgs.add(img);
		}
		
		{
			ProductImage img= new ProductImage();
			img.setType(TypeEnum.TH);
			img.setContentType("png");
			img.setFileName("img/11_th_30.png");
			imgs.add(img);
		}
		
		response.setProductImages(imgs);

		List<ProductPrice> prices= new ArrayList<>();
		{
			ProductPrice price= new ProductPrice();
			price.setPrice(15000);
			price.setProductId(1);
			prices.add(price);
		}

		response.setProductPrices(prices);
		
	
		return response;
	}
}
