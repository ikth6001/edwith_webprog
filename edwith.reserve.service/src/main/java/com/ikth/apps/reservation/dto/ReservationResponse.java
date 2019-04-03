package com.ikth.apps.reservation.dto;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 예약하기 Response 모델
 */
@ApiModel(description = "예약하기 Response 모델")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-05T12:37:37.915+09:00")

public class ReservationResponse   {
  @JsonProperty("cancelYn")
  private Boolean cancelYn = null;

  @JsonProperty("createDate")
  private OffsetDateTime createDate = null;

  @JsonProperty("displayInfoId")
  private Integer displayInfoId = null;

  @JsonProperty("modifyDate")
  private OffsetDateTime modifyDate = null;

  @JsonProperty("prices")
  @Valid
  private List<ReservationPrice> prices = null;

  @JsonProperty("productId")
  private Integer productId = null;

  @JsonProperty("reservationDate")
  private LocalDate reservationDate = null;

  @JsonProperty("reservationEmail")
  private String reservationEmail = null;

  @JsonProperty("reservationInfoId")
  private Integer reservationInfoId = null;

  @JsonProperty("reservationName")
  private String reservationName = null;

  @JsonProperty("reservationTelephone")
  private String reservationTelephone = null;

  public ReservationResponse cancelYn(Boolean cancelYn) {
    this.cancelYn = cancelYn;
    return this;
  }

  /**
   * 취소여부
   * @return cancelYn
  **/
  @ApiModelProperty(value = "취소여부")


  public Boolean isCancelYn() {
    return cancelYn;
  }

  public void setCancelYn(Boolean cancelYn) {
    this.cancelYn = cancelYn;
  }

  public ReservationResponse createDate(OffsetDateTime createDate) {
    this.createDate = createDate;
    return this;
  }

  /**
   * 예약 생성일시
   * @return createDate
  **/
  @ApiModelProperty(value = "예약 생성일시")

  @Valid

  public OffsetDateTime getCreateDate() {
    return createDate;
  }

  public void setCreateDate(OffsetDateTime createDate) {
    this.createDate = createDate;
  }

  public ReservationResponse displayInfoId(Integer displayInfoId) {
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

  public ReservationResponse modifyDate(OffsetDateTime modifyDate) {
    this.modifyDate = modifyDate;
    return this;
  }

  /**
   * 예약 수정일시
   * @return modifyDate
  **/
  @ApiModelProperty(value = "예약 수정일시")

  @Valid

  public OffsetDateTime getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(OffsetDateTime modifyDate) {
    this.modifyDate = modifyDate;
  }

  public ReservationResponse prices(List<ReservationPrice> prices) {
    this.prices = prices;
    return this;
  }

  public ReservationResponse addPricesItem(ReservationPrice pricesItem) {
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

  public ReservationResponse productId(Integer productId) {
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

  public ReservationResponse reservationDate(LocalDate reservationDate) {
    this.reservationDate = reservationDate;
    return this;
  }

  /**
   * 예약일
   * @return reservationDate
  **/
  @ApiModelProperty(value = "예약일")

  @Valid

  public LocalDate getReservationDate() {
    return reservationDate;
  }

  public void setReservationDate(LocalDate reservationDate) {
    this.reservationDate = reservationDate;
  }

  public ReservationResponse reservationEmail(String reservationEmail) {
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

  public ReservationResponse reservationInfoId(Integer reservationInfoId) {
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

  public ReservationResponse reservationName(String reservationName) {
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

  public ReservationResponse reservationTelephone(String reservationTelephone) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationResponse reservationResponse = (ReservationResponse) o;
    return Objects.equals(this.cancelYn, reservationResponse.cancelYn) &&
        Objects.equals(this.createDate, reservationResponse.createDate) &&
        Objects.equals(this.displayInfoId, reservationResponse.displayInfoId) &&
        Objects.equals(this.modifyDate, reservationResponse.modifyDate) &&
        Objects.equals(this.prices, reservationResponse.prices) &&
        Objects.equals(this.productId, reservationResponse.productId) &&
        Objects.equals(this.reservationDate, reservationResponse.reservationDate) &&
        Objects.equals(this.reservationEmail, reservationResponse.reservationEmail) &&
        Objects.equals(this.reservationInfoId, reservationResponse.reservationInfoId) &&
        Objects.equals(this.reservationName, reservationResponse.reservationName) &&
        Objects.equals(this.reservationTelephone, reservationResponse.reservationTelephone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cancelYn, createDate, displayInfoId, modifyDate, prices, productId, reservationDate, reservationEmail, reservationInfoId, reservationName, reservationTelephone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationResponse {\n");
    
    sb.append("    cancelYn: ").append(toIndentedString(cancelYn)).append("\n");
    sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
    sb.append("    displayInfoId: ").append(toIndentedString(displayInfoId)).append("\n");
    sb.append("    modifyDate: ").append(toIndentedString(modifyDate)).append("\n");
    sb.append("    prices: ").append(toIndentedString(prices)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    reservationDate: ").append(toIndentedString(reservationDate)).append("\n");
    sb.append("    reservationEmail: ").append(toIndentedString(reservationEmail)).append("\n");
    sb.append("    reservationInfoId: ").append(toIndentedString(reservationInfoId)).append("\n");
    sb.append("    reservationName: ").append(toIndentedString(reservationName)).append("\n");
    sb.append("    reservationTelephone: ").append(toIndentedString(reservationTelephone)).append("\n");
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

