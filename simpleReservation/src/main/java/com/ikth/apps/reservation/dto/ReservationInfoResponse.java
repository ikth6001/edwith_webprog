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
 * 예약조회 Response 모델
 */
@ApiModel(description = "예약조회 Response 모델")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-05T12:37:37.915+09:00")

public class ReservationInfoResponse   {
  @JsonProperty("reservations")
  @Valid
  private List<ReservationInfo> reservations = null;

  @JsonProperty("size")
  private Integer size = null;

  public ReservationInfoResponse reservations(List<ReservationInfo> reservations) {
    this.reservations = reservations;
    return this;
  }

  public ReservationInfoResponse addReservationsItem(ReservationInfo reservationsItem) {
    if (this.reservations == null) {
      this.reservations = new ArrayList<ReservationInfo>();
    }
    this.reservations.add(reservationsItem);
    return this;
  }

  /**
   * 예약 정보들
   * @return reservations
  **/
  @ApiModelProperty(value = "예약 정보들")

  @Valid

  public List<ReservationInfo> getReservations() {
    return reservations;
  }

  public void setReservations(List<ReservationInfo> reservations) {
    this.reservations = reservations;
  }

  public ReservationInfoResponse size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * 예약 수
   * @return size
  **/
  @ApiModelProperty(value = "예약 수")


  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationInfoResponse reservationInfoResponse = (ReservationInfoResponse) o;
    return Objects.equals(this.reservations, reservationInfoResponse.reservations) &&
        Objects.equals(this.size, reservationInfoResponse.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reservations, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationInfoResponse {\n");
    
    sb.append("    reservations: ").append(toIndentedString(reservations)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

