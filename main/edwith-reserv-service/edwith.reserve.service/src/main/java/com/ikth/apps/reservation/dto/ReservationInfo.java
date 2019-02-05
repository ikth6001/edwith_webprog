package com.ikth.apps.reservation.dto;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 예약정보 모델
 */
@ApiModel(description = "예약정보 모델")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-05T12:37:37.915+09:00")

public class ReservationInfo   {
  @JsonProperty("cancelYn")
  private Boolean cancelYn = null;

  @JsonProperty("createDate")
  private OffsetDateTime createDate = null;

  @JsonProperty("displayInfo")
  private DisplayInfo displayInfo = null;

  @JsonProperty("displayInfoId")
  private Integer displayInfoId = null;

  @JsonProperty("modifyDate")
  private OffsetDateTime modifyDate = null;

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

  @JsonProperty("totalPrice")
  private Long totalPrice = null;

  public ReservationInfo cancelYn(Boolean cancelYn) {
    this.cancelYn = cancelYn;
    return this;
  }

  /**
   * 예약 취소 여부
   * @return cancelYn
  **/
  @ApiModelProperty(value = "예약 취소 여부")


  public Boolean isCancelYn() {
    return cancelYn;
  }

  public void setCancelYn(Boolean cancelYn) {
    this.cancelYn = cancelYn;
  }

  public ReservationInfo createDate(OffsetDateTime createDate) {
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

  public ReservationInfo displayInfo(DisplayInfo displayInfo) {
    this.displayInfo = displayInfo;
    return this;
  }

  /**
   * 전시상품 정보
   * @return displayInfo
  **/
  @ApiModelProperty(value = "전시상품 정보")

  @Valid

  public DisplayInfo getDisplayInfo() {
    return displayInfo;
  }

  public void setDisplayInfo(DisplayInfo displayInfo) {
    this.displayInfo = displayInfo;
  }

  public ReservationInfo displayInfoId(Integer displayInfoId) {
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

  public ReservationInfo modifyDate(OffsetDateTime modifyDate) {
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

  public ReservationInfo productId(Integer productId) {
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

  public ReservationInfo reservationDate(LocalDate reservationDate) {
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

  public ReservationInfo reservationEmail(String reservationEmail) {
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

  public ReservationInfo reservationInfoId(Integer reservationInfoId) {
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

  public ReservationInfo reservationName(String reservationName) {
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

  public ReservationInfo reservationTelephone(String reservationTelephone) {
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

  public ReservationInfo totalPrice(Long totalPrice) {
    this.totalPrice = totalPrice;
    return this;
  }

  /**
   * 예약한 상품 총 가격
   * @return totalPrice
  **/
  @ApiModelProperty(value = "예약한 상품 총 가격")


  public Long getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Long totalPrice) {
    this.totalPrice = totalPrice;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationInfo reservationInfo = (ReservationInfo) o;
    return Objects.equals(this.cancelYn, reservationInfo.cancelYn) &&
        Objects.equals(this.createDate, reservationInfo.createDate) &&
        Objects.equals(this.displayInfo, reservationInfo.displayInfo) &&
        Objects.equals(this.displayInfoId, reservationInfo.displayInfoId) &&
        Objects.equals(this.modifyDate, reservationInfo.modifyDate) &&
        Objects.equals(this.productId, reservationInfo.productId) &&
        Objects.equals(this.reservationDate, reservationInfo.reservationDate) &&
        Objects.equals(this.reservationEmail, reservationInfo.reservationEmail) &&
        Objects.equals(this.reservationInfoId, reservationInfo.reservationInfoId) &&
        Objects.equals(this.reservationName, reservationInfo.reservationName) &&
        Objects.equals(this.reservationTelephone, reservationInfo.reservationTelephone) &&
        Objects.equals(this.totalPrice, reservationInfo.totalPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cancelYn, createDate, displayInfo, displayInfoId, modifyDate, productId, reservationDate, reservationEmail, reservationInfoId, reservationName, reservationTelephone, totalPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationInfo {\n");
    
    sb.append("    cancelYn: ").append(toIndentedString(cancelYn)).append("\n");
    sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
    sb.append("    displayInfo: ").append(toIndentedString(displayInfo)).append("\n");
    sb.append("    displayInfoId: ").append(toIndentedString(displayInfoId)).append("\n");
    sb.append("    modifyDate: ").append(toIndentedString(modifyDate)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    reservationDate: ").append(toIndentedString(reservationDate)).append("\n");
    sb.append("    reservationEmail: ").append(toIndentedString(reservationEmail)).append("\n");
    sb.append("    reservationInfoId: ").append(toIndentedString(reservationInfoId)).append("\n");
    sb.append("    reservationName: ").append(toIndentedString(reservationName)).append("\n");
    sb.append("    reservationTelephone: ").append(toIndentedString(reservationTelephone)).append("\n");
    sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
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

