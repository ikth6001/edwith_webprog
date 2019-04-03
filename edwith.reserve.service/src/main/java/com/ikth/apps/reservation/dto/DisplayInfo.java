package com.ikth.apps.reservation.dto;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 상품 전시 (Display) 모델
 */
@ApiModel(description = "상품 전시 (Display) 모델")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-05T12:37:37.915+09:00")

public class DisplayInfo   {
  @JsonProperty("categoryId")
  private Integer categoryId = null;

  @JsonProperty("categoryName")
  private String categoryName = null;

  @JsonProperty("createDate")
  private OffsetDateTime createDate = null;

  @JsonProperty("displayInfoId")
  private Integer displayInfoId = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("homepage")
  private String homepage = null;

  @JsonProperty("modifyDate")
  private OffsetDateTime modifyDate = null;

  @JsonProperty("openingHours")
  private String openingHours = null;

  @JsonProperty("placeLot")
  private String placeLot = null;

  @JsonProperty("placeName")
  private String placeName = null;

  @JsonProperty("placeStreet")
  private String placeStreet = null;

  @JsonProperty("productContent")
  private String productContent = null;

  @JsonProperty("productDescription")
  private String productDescription = null;

  @JsonProperty("productEvent")
  private String productEvent = null;

  @JsonProperty("productId")
  private Integer productId = null;

  @JsonProperty("telephone")
  private String telephone = null;

  public DisplayInfo categoryId(Integer categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * 카테고리 (category) Id
   * @return categoryId
  **/
  @ApiModelProperty(value = "카테고리 (category) Id")


  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public DisplayInfo categoryName(String categoryName) {
    this.categoryName = categoryName;
    return this;
  }

  /**
   * 카테고리 이름
   * @return categoryName
  **/
  @ApiModelProperty(value = "카테고리 이름")


  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public DisplayInfo createDate(OffsetDateTime createDate) {
    this.createDate = createDate;
    return this;
  }

  /**
   * 생성일
   * @return createDate
  **/
  @ApiModelProperty(value = "생성일")

  @Valid

  public OffsetDateTime getCreateDate() {
    return createDate;
  }

  public void setCreateDate(OffsetDateTime createDate) {
    this.createDate = createDate;
  }

  public DisplayInfo displayInfoId(Integer displayInfoId) {
    this.displayInfoId = displayInfoId;
    return this;
  }

  /**
   * 전시 (display_info) Id
   * @return displayInfoId
  **/
  @ApiModelProperty(value = "전시 (display_info) Id")


  public Integer getDisplayInfoId() {
    return displayInfoId;
  }

  public void setDisplayInfoId(Integer displayInfoId) {
    this.displayInfoId = displayInfoId;
  }

  public DisplayInfo email(String email) {
    this.email = email;
    return this;
  }

  /**
   * 이메일
   * @return email
  **/
  @ApiModelProperty(value = "이메일")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public DisplayInfo homepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  /**
   * 홈페이지
   * @return homepage
  **/
  @ApiModelProperty(value = "홈페이지")


  public String getHomepage() {
    return homepage;
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  public DisplayInfo modifyDate(OffsetDateTime modifyDate) {
    this.modifyDate = modifyDate;
    return this;
  }

  /**
   * 수정일
   * @return modifyDate
  **/
  @ApiModelProperty(value = "수정일")

  @Valid

  public OffsetDateTime getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(OffsetDateTime modifyDate) {
    this.modifyDate = modifyDate;
  }

  public DisplayInfo openingHours(String openingHours) {
    this.openingHours = openingHours;
    return this;
  }

  /**
   * 전시 시간
   * @return openingHours
  **/
  @ApiModelProperty(value = "전시 시간")


  public String getOpeningHours() {
    return openingHours;
  }

  public void setOpeningHours(String openingHours) {
    this.openingHours = openingHours;
  }

  public DisplayInfo placeLot(String placeLot) {
    this.placeLot = placeLot;
    return this;
  }

  /**
   * 전시 번지명
   * @return placeLot
  **/
  @ApiModelProperty(value = "전시 번지명")


  public String getPlaceLot() {
    return placeLot;
  }

  public void setPlaceLot(String placeLot) {
    this.placeLot = placeLot;
  }

  public DisplayInfo placeName(String placeName) {
    this.placeName = placeName;
    return this;
  }

  /**
   * 전시장
   * @return placeName
  **/
  @ApiModelProperty(value = "전시장")


  public String getPlaceName() {
    return placeName;
  }

  public void setPlaceName(String placeName) {
    this.placeName = placeName;
  }

  public DisplayInfo placeStreet(String placeStreet) {
    this.placeStreet = placeStreet;
    return this;
  }

  /**
   * 전시 도로명
   * @return placeStreet
  **/
  @ApiModelProperty(value = "전시 도로명")


  public String getPlaceStreet() {
    return placeStreet;
  }

  public void setPlaceStreet(String placeStreet) {
    this.placeStreet = placeStreet;
  }

  public DisplayInfo productContent(String productContent) {
    this.productContent = productContent;
    return this;
  }

  /**
   * 상품 내용
   * @return productContent
  **/
  @ApiModelProperty(value = "상품 내용")


  public String getProductContent() {
    return productContent;
  }

  public void setProductContent(String productContent) {
    this.productContent = productContent;
  }

  public DisplayInfo productDescription(String productDescription) {
    this.productDescription = productDescription;
    return this;
  }

  /**
   * 상품 설명
   * @return productDescription
  **/
  @ApiModelProperty(value = "상품 설명")


  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public DisplayInfo productEvent(String productEvent) {
    this.productEvent = productEvent;
    return this;
  }

  /**
   * 상품 이벤트
   * @return productEvent
  **/
  @ApiModelProperty(value = "상품 이벤트")


  public String getProductEvent() {
    return productEvent;
  }

  public void setProductEvent(String productEvent) {
    this.productEvent = productEvent;
  }

  public DisplayInfo productId(Integer productId) {
    this.productId = productId;
    return this;
  }

  /**
   * 상품 (product) Id
   * @return productId
  **/
  @ApiModelProperty(value = "상품 (product) Id")


  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public DisplayInfo telephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  /**
   * 전화번호
   * @return telephone
  **/
  @ApiModelProperty(value = "전화번호")


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DisplayInfo displayInfo = (DisplayInfo) o;
    return Objects.equals(this.categoryId, displayInfo.categoryId) &&
        Objects.equals(this.categoryName, displayInfo.categoryName) &&
        Objects.equals(this.createDate, displayInfo.createDate) &&
        Objects.equals(this.displayInfoId, displayInfo.displayInfoId) &&
        Objects.equals(this.email, displayInfo.email) &&
        Objects.equals(this.homepage, displayInfo.homepage) &&
        Objects.equals(this.modifyDate, displayInfo.modifyDate) &&
        Objects.equals(this.openingHours, displayInfo.openingHours) &&
        Objects.equals(this.placeLot, displayInfo.placeLot) &&
        Objects.equals(this.placeName, displayInfo.placeName) &&
        Objects.equals(this.placeStreet, displayInfo.placeStreet) &&
        Objects.equals(this.productContent, displayInfo.productContent) &&
        Objects.equals(this.productDescription, displayInfo.productDescription) &&
        Objects.equals(this.productEvent, displayInfo.productEvent) &&
        Objects.equals(this.productId, displayInfo.productId) &&
        Objects.equals(this.telephone, displayInfo.telephone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryId, categoryName, createDate, displayInfoId, email, homepage, modifyDate, openingHours, placeLot, placeName, placeStreet, productContent, productDescription, productEvent, productId, telephone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DisplayInfo {\n");
    
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    categoryName: ").append(toIndentedString(categoryName)).append("\n");
    sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
    sb.append("    displayInfoId: ").append(toIndentedString(displayInfoId)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    homepage: ").append(toIndentedString(homepage)).append("\n");
    sb.append("    modifyDate: ").append(toIndentedString(modifyDate)).append("\n");
    sb.append("    openingHours: ").append(toIndentedString(openingHours)).append("\n");
    sb.append("    placeLot: ").append(toIndentedString(placeLot)).append("\n");
    sb.append("    placeName: ").append(toIndentedString(placeName)).append("\n");
    sb.append("    placeStreet: ").append(toIndentedString(placeStreet)).append("\n");
    sb.append("    productContent: ").append(toIndentedString(productContent)).append("\n");
    sb.append("    productDescription: ").append(toIndentedString(productDescription)).append("\n");
    sb.append("    productEvent: ").append(toIndentedString(productEvent)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

