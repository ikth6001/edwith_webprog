package com.ikth.apps.reservation.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 프로모션 (promotion) 모델
 */
@ApiModel(description = "프로모션 (promotion) 모델")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-05T12:37:37.915+09:00")

public class Promotion   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("productId")
  private Integer productId = null;

  @JsonProperty("productImageUrl")
  private String productImageUrl = null;

  public Promotion id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * 프로모션 (promotion) Id
   * @return id
  **/
  @ApiModelProperty(value = "프로모션 (promotion) Id")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Promotion productId(Integer productId) {
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

  public Promotion productImageUrl(String productImageUrl) {
    this.productImageUrl = productImageUrl;
    return this;
  }

  /**
   * 상품 썸네일 이미지 URL
   * @return productImageUrl
  **/
  @ApiModelProperty(value = "상품 썸네일 이미지 URL")


  public String getProductImageUrl() {
    return productImageUrl;
  }

  public void setProductImageUrl(String productImageUrl) {
    this.productImageUrl = productImageUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Promotion promotion = (Promotion) o;
    return Objects.equals(this.id, promotion.id) &&
        Objects.equals(this.productId, promotion.productId) &&
        Objects.equals(this.productImageUrl, promotion.productImageUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, productId, productImageUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Promotion {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    productImageUrl: ").append(toIndentedString(productImageUrl)).append("\n");
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

