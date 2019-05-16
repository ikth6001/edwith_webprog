package com.ikth.apps.reservation.dto;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 상품 가격
 */
@ApiModel(description = "상품 가격")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-05T12:37:37.915+09:00")

public class ProductPrice   {
  @JsonProperty("createDate")
  private OffsetDateTime createDate = null;

  @JsonProperty("discountRate")
  private Double discountRate = null;

  @JsonProperty("modifyDate")
  private OffsetDateTime modifyDate = null;

  @JsonProperty("price")
  private Integer price = null;

  @JsonProperty("priceTypeName")
  private String priceTypeName = null;

  @JsonProperty("productId")
  private Integer productId = null;

  @JsonProperty("productPriceId")
  private Integer productPriceId = null;

  public ProductPrice createDate(OffsetDateTime createDate) {
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

  public ProductPrice discountRate(Double discountRate) {
    this.discountRate = discountRate;
    return this;
  }

  /**
   * 할인율
   * @return discountRate
  **/
  @ApiModelProperty(value = "할인율")


  public Double getDiscountRate() {
    return discountRate;
  }

  public void setDiscountRate(Double discountRate) {
    this.discountRate = discountRate;
  }

  public ProductPrice modifyDate(OffsetDateTime modifyDate) {
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

  public ProductPrice price(Integer price) {
    this.price = price;
    return this;
  }

  /**
   * 가격
   * @return price
  **/
  @ApiModelProperty(value = "가격")


  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public ProductPrice priceTypeName(String priceTypeName) {
    this.priceTypeName = priceTypeName;
    return this;
  }

  /**
   * 가격 타입명
   * @return priceTypeName
  **/
  @ApiModelProperty(value = "가격 타입명")


  public String getPriceTypeName() {
    return priceTypeName;
  }

  public void setPriceTypeName(String priceTypeName) {
    this.priceTypeName = priceTypeName;
  }

  public ProductPrice productId(Integer productId) {
    this.productId = productId;
    return this;
  }

  /**
   * 상품 Id
   * @return productId
  **/
  @ApiModelProperty(value = "상품 Id")


  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public ProductPrice productPriceId(Integer productPriceId) {
    this.productPriceId = productPriceId;
    return this;
  }

  /**
   * 상품 가격 Id
   * @return productPriceId
  **/
  @ApiModelProperty(value = "상품 가격 Id")


  public Integer getProductPriceId() {
    return productPriceId;
  }

  public void setProductPriceId(Integer productPriceId) {
    this.productPriceId = productPriceId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductPrice productPrice = (ProductPrice) o;
    return Objects.equals(this.createDate, productPrice.createDate) &&
        Objects.equals(this.discountRate, productPrice.discountRate) &&
        Objects.equals(this.modifyDate, productPrice.modifyDate) &&
        Objects.equals(this.price, productPrice.price) &&
        Objects.equals(this.priceTypeName, productPrice.priceTypeName) &&
        Objects.equals(this.productId, productPrice.productId) &&
        Objects.equals(this.productPriceId, productPrice.productPriceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createDate, discountRate, modifyDate, price, priceTypeName, productId, productPriceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductPrice {\n");
    
    sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
    sb.append("    discountRate: ").append(toIndentedString(discountRate)).append("\n");
    sb.append("    modifyDate: ").append(toIndentedString(modifyDate)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    priceTypeName: ").append(toIndentedString(priceTypeName)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    productPriceId: ").append(toIndentedString(productPriceId)).append("\n");
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

