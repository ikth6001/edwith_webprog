package com.ikth.apps.reserve.product.vo;

public class ProductVO 
{
	private String name;
	private String description;
	private String place;
	private String typeCd;
	private boolean promotion;
	private String imgBase64;
	
	public ProductVO() { }
	
	public ProductVO(String name
			, String description
			, String place
			, String typeCd
			, boolean promotion
			, String imgBase64) 
	{
		this.name= name;
		this.description= description;
		this.place= place;
		this.typeCd= typeCd;
		this.promotion= promotion;
		this.imgBase64= imgBase64;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTypeCd() {
		return typeCd;
	}
	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
	}
	public boolean isPromotion() {
		return promotion;
	}
	public void setPromotion(boolean promotion) {
		this.promotion = promotion;
	}
	public String getImgBase64() {
		return imgBase64;
	}
	public void setImgBase64(String imgBase64) {
		this.imgBase64 = imgBase64;
	}
}
