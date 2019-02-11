package com.ikth.apps.reservation.service;

import java.time.OffsetDateTime;
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
import com.ikth.apps.reservation.dto.ProductImage.TypeEnum;
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
			category.setName("전시");
			category.setId(1);
			categories.add(category);
		}
		
		{
			Category category= new Category();
			category.setName("뮤지컬");
			category.setId(2);
			categories.add(category);
		}
		
		{
			Category category= new Category();
			category.setName("콘서트");
			category.setId(3);
			categories.add(category);
		}
		
		{
			Category category= new Category();
			category.setName("클래식");
			category.setId(4);
			categories.add(category);
		}
		
		{
			Category category= new Category();
			category.setName("연극");
			category.setId(5);
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
		
		{
			ProductImage img= new ProductImage();
			img.setType(TypeEnum.MA);
			img.setContentType("png");
			img.setFileName("img/1_ma_2.png");
			imgs.add(img);
		}
		response.setProductImages(imgs);
		
		DisplayInfo displayInfo= new DisplayInfo();
		displayInfo.setCategoryId(1);
		displayInfo.setCategoryName("전시");
		displayInfo.setPlaceName("상암 월드컵 경기장");
		displayInfo.setDisplayInfoId(1);
		displayInfo.productContent(
				"알렉산더 지라드, 디자이너의 세계 展"
				+ "<br>Alexander Girard, A Designer's Universe"
				+ "<br><br>"
				+ "<br>2017년 12월 22일부터 2018년 3월 4일까지 예술의전당 한가람미술관에서 20세기 미국 모던디자인을 대표하는 시대의 아이콘, 알렉산더 지라드의 대규모 회고전을 아시아 최초로 개최한다. 이번 전시는 지라드의 인테리어와 사진, 텍스타일, 가구, 장식소품, 수집품 등 5,000여 점 이상의 작품을 소장하고 있는 비트라 디자인 미술관(Vitra Design Museum)이 그의 삶과 작품세계를 심층적으로 연구해 기획되었으며, 700여 점의 작품을 총 4부로 구성해 종합적이며 다이나믹하게 보여준다."
				+ "<br>이번 대규모 알렉산더 지라드 회고전에서는 전 세계적으로 큰 사랑을 받고 있는 작품 <LOVE>, <International LOVE>를 포함해 토탈디자인을 추구했던 그의 완전한 디자인 세계를 생생하게 경험할 수 있다. 뿐만 아니라 지라드와 협력한 동시대의 유명 건축가, 디자이너, 예술가인 찰스 임스와 레이 임스(Charles Eames and Ray Eames), 조지 넬슨(George Nelson), 조지아 오키프(Georgia O'keefe), 에밀리오 푸치(Emilio Pucci)등 과의 관계 및 영향 또한 살펴볼 수 있다."
				+ "<br>국내에 베어브릭과 목각인형 컬렉션으로 탄탄한 마니아층을 보유하고 있는 알렉산더 지라드의 디자인은 이번 전시를 통해 국내의 많은 인테리어 디자인 애호가는 물론이고 전 세대를 아울러 특별한 경험을 선물할 것으로 기대한다.");

		displayInfo.setHomepage("http://alexander.story.co.kr");
		displayInfo.productDescription("알렉산더 지라드전");
		displayInfo.setTelephone("010-****-****");
		displayInfo.setProductEvent("[크리스마스 특별 이벤트]\nR석 50%, S석 60% 할인");
		response.setDisplayInfo(displayInfo);
		
		response.setAverageScore(3.5);
		
		
		List<Comment> comments= new ArrayList<>();
		{
			Comment comm= new Comment();
			comm.setCommentId(1);
			comm.setProductId(1);
			comm.setReservationName("로미오와 줄리엣 !!!");
			comm.setReservationEmail("ikth6001@gmail.com");
			comm.setComment("2층이어서 걱정했는데 잘보여서 좋았습니다. 너무 너무 재밌었습니다.");
			comm.setScore(3.0d);
			comm.setCreateDate(OffsetDateTime.now());
			
			comments.add(comm);
		}
		
		{
			Comment comm= new Comment();
			comm.setCommentId(2);
			comm.setProductId(1);
			comm.setReservationName("iljy6001@yahoo.co.kr");
			comm.setComment("남자친구는 재밌게 봤다는데.. 저는 지루해서 졸았어요..");
			comm.setScore(2.0d);
			comm.setCreateDate(OffsetDateTime.now());
			
			comments.add(comm);
		}
		
		response.setComments(comments);

		return response;
	}
}
