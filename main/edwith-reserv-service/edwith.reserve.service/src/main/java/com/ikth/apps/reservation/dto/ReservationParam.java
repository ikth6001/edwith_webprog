package com.ikth.apps.reservation.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 예약하기 Request Body 모델
 */
@ApiModel(description = "예약하기 Request Body 모델")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-05T12:37:37.915+09:00")

public class ReservationParam   {
  @JsonProperty("displayInfoId")
  private Integer displayInfoId = null;

  @JsonProperty("prices")
  @Valid
  private List<ReservationPrice> prices = null;

  @JsonProperty("productId")
  private Integer productId = null;

  @JsonProperty("reservationEmail")
  private String reservationEmail = null;

  @JsonProperty("reservationName")
  private String reservationName = null;

  @JsonProperty("reservationTelephone")
  private String reservationTelephone = null;

  @JsonProperty("reservationYearMonthDay")
  private String reservationYearMonthDay = null;

  public ReservationParam displayInfoId(Integer displayInfoId) {
    this.displayInfoId = displayInfoId;
    return this;
  }

  /**
   * 전시상품 Id
   * @return displayInfoId
  **/
  @ApiModelProperty(value = "전시상품 Id")


  public Integer getDisplayInfoId() {
    return displayInfoId;
  }

  public void setDisplayInfoId(Integer displayInfoId) {
    this.displayInfoId = displayInfoId;
  }

  public ReservationParam prices(List<ReservationPrice> prices) {
    this.prices = prices;
    return this;
  }

  public ReservationParam addPricesItem(ReservationPrice pricesItem) {
    if (this.prices == null) {
      this.prices = new ArrayList<ReservationPrice>();
    }
    this.prices.add(pricesItem);
    return this;
  }

  /**
   * 예약 가격 정보
   * @return prices
  **/
  @ApiModelProperty(value = "예약 가격 정보")

  @Valid

  public List<ReservationPrice> getPrices() {
    return prices;
  }

  public void setPrices(List<ReservationPrice> prices) {
    this.prices = prices;
  }

  public ReservationParam productId(Integer productId) {
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

  public ReservationParam reservationEmail(String reservationEmail) {
    this.reservationEmail = reservationEmail;
    return this;
  }

  /**
   * 예약자 이메일
   * @return reservationEmail
  **/
  @ApiModelProperty(value = "예약자 이메일")


  public String getReservationEmail() {
    return reservationEmail;
  }

  public void setReservationEmail(String reservationEmail) {
    this.reservationEmail = reservationEmail;
  }

  public ReservationParam reservationName(String reservationName) {
    this.reservationName = reservationName;
    return this;
  }

  /**
   * 예약자명
   * @return reservationName
  **/
  @ApiModelProperty(value = "예약자명")


  public String getReservationName() {
    return reservationName;
  }

  public void setReservationName(String reservationName) {
    this.reservationName = reservationName;
  }

  public ReservationParam reservationTelephone(String reservationTelephone) {
    this.reservationTelephone = reservationTelephone;
    return this;
  }

  /**
   * 예약자 전화번호
   * @return reservationTelephone
  **/
  @ApiModelProperty(value = "예약자 전화번호")


  public String getReservationTelephone() {
    return reservationTelephone;
  }

  public void setReservationTelephone(String reservationTelephone) {
    this.reservationTelephone = reservationTelephone;
  }

  public ReservationParam reservationYearMonthDay(String reservationYearMonthDay) {
    this.reservationYearMonthDay = reservationYearMonthDay;
    return this;
  }

  /**
   * 예약일
   * @return reservationYearMonthDay
  **/
  @ApiModelProperty(value = "예약일")


  public String getReservationYearMonthDay() {
    return reservationYearMonthDay;
  }

  public void setReservationYearMonthDay(String reservationYearMonthDay) {
    this.reservationYearMonthDay = reservationYearMonthDay;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationParam reservationParam = (ReservationParam) o;
    return Objects.equals(this.displayInfoId, reservationParam.displayInfoId) &&
        Objects.equals(this.prices, reservationParam.prices) &&
        Objects.equals(this.productId, reservationParam.productId) &&
        Objects.equals(this.reservationEmail, reservationParam.reservationEmail) &&
        Objects.equals(this.reservationName, reservationParam.reservationName) &&
        Objects.equals(this.reservationTelephone, reservationParam.reservationTelephone) &&
        Objects.equals(this.reservationYearMonthDay, reservationParam.reservationYearMonthDay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayInfoId, prices, productId, reservationEmail, reservationName, reservationTelephone, reservationYearMonthDay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationParam {\n");
    
    sb.append("    displayInfoId: ").append(toIndentedString(displayInfoId)).append("\n");
    sb.append("    prices: ").append(toIndentedString(prices)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    reservationEmail: ").append(toIndentedString(reservationEmail)).append("\n");
    sb.append("    reservationName: ").append(toIndentedString(reservationName)).append("\n");
    sb.append("    reservationTelephone: ").append(toIndentedString(reservationTelephone)).append("\n");
    sb.append("    reservationYearMonthDay: ").append(toIndentedString(reservationYearMonthDay)).append("\n");
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

