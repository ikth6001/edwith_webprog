package com.ikth.apps.reservation.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 예약가격 내역
 */
@ApiModel(description = "예약가격 내역")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-05T12:37:37.915+09:00")

public class ReservationPrice   {
  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("productPriceId")
  private Integer productPriceId = null;

  @JsonProperty("reservationInfoId")
  private Integer reservationInfoId = null;

  @JsonProperty("reservationInfoPriceId")
  private Integer reservationInfoPriceId = null;

  public ReservationPrice count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * 예약 상품 수
   * @return count
  **/
  @ApiModelProperty(value = "예약 상품 수")


  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public ReservationPrice productPriceId(Integer productPriceId) {
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

  public ReservationPrice reservationInfoId(Integer reservationInfoId) {
    this.reservationInfoId = reservationInfoId;
    return this;
  }

  /**
   * 예약 Id
   * @return reservationInfoId
  **/
  @ApiModelProperty(value = "예약 Id")


  public Integer getReservationInfoId() {
    return reservationInfoId;
  }

  public void setReservationInfoId(Integer reservationInfoId) {
    this.reservationInfoId = reservationInfoId;
  }

  public ReservationPrice reservationInfoPriceId(Integer reservationInfoPriceId) {
    this.reservationInfoPriceId = reservationInfoPriceId;
    return this;
  }

  /**
   * 예약 가격 Id
   * @return reservationInfoPriceId
  **/
  @ApiModelProperty(value = "예약 가격 Id")


  public Integer getReservationInfoPriceId() {
    return reservationInfoPriceId;
  }

  public void setReservationInfoPriceId(Integer reservationInfoPriceId) {
    this.reservationInfoPriceId = reservationInfoPriceId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationPrice reservationPrice = (ReservationPrice) o;
    return Objects.equals(this.count, reservationPrice.count) &&
        Objects.equals(this.productPriceId, reservationPrice.productPriceId) &&
        Objects.equals(this.reservationInfoId, reservationPrice.reservationInfoId) &&
        Objects.equals(this.reservationInfoPriceId, reservationPrice.reservationInfoPriceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, productPriceId, reservationInfoId, reservationInfoPriceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationPrice {\n");
    
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    productPriceId: ").append(toIndentedString(productPriceId)).append("\n");
    sb.append("    reservationInfoId: ").append(toIndentedString(reservationInfoId)).append("\n");
    sb.append("    reservationInfoPriceId: ").append(toIndentedString(reservationInfoPriceId)).append("\n");
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

