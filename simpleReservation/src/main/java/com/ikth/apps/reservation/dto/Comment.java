package com.ikth.apps.reservation.dto;

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
 * 상품평
 */
@ApiModel(description = "상품평")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-05T12:37:37.915+09:00")

public class Comment   {
  @JsonProperty("comment")
  private String comment = null;

  @JsonProperty("commentId")
  private Integer commentId = null;

  @JsonProperty("commentImages")
  @Valid
  private List<CommentImage> commentImages = null;

  @JsonProperty("createDate")
  private OffsetDateTime createDate = null;

  @JsonProperty("modifyDate")
  private OffsetDateTime modifyDate = null;

  @JsonProperty("productId")
  private Integer productId = null;

  @JsonProperty("reservationDate")
  private OffsetDateTime reservationDate = null;

  @JsonProperty("reservationEmail")
  private String reservationEmail = null;

  @JsonProperty("reservationInfoId")
  private Integer reservationInfoId = null;

  @JsonProperty("reservationName")
  private String reservationName = null;

  @JsonProperty("reservationTelephone")
  private String reservationTelephone = null;

  @JsonProperty("score")
  private Double score = null;

  public Comment comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * 상품평
   * @return comment
  **/
  @ApiModelProperty(value = "상품평")


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Comment commentId(Integer commentId) {
    this.commentId = commentId;
    return this;
  }

  /**
   * 상품평 Id
   * @return commentId
  **/
  @ApiModelProperty(value = "상품평 Id")


  public Integer getCommentId() {
    return commentId;
  }

  public void setCommentId(Integer commentId) {
    this.commentId = commentId;
  }

  public Comment commentImages(List<CommentImage> commentImages) {
    this.commentImages = commentImages;
    return this;
  }

  public Comment addCommentImagesItem(CommentImage commentImagesItem) {
    if (this.commentImages == null) {
      this.commentImages = new ArrayList<CommentImage>();
    }
    this.commentImages.add(commentImagesItem);
    return this;
  }

  /**
   * 상품평 이미지들
   * @return commentImages
  **/
  @ApiModelProperty(value = "상품평 이미지들")

  @Valid

  public List<CommentImage> getCommentImages() {
    return commentImages;
  }

  public void setCommentImages(List<CommentImage> commentImages) {
    this.commentImages = commentImages;
  }

  public Comment createDate(OffsetDateTime createDate) {
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

  public Comment modifyDate(OffsetDateTime modifyDate) {
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

  public Comment productId(Integer productId) {
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

  public Comment reservationDate(OffsetDateTime reservationDate) {
    this.reservationDate = reservationDate;
    return this;
  }

  /**
   * 예약일
   * @return reservationDate
  **/
  @ApiModelProperty(value = "예약일")

  @Valid

  public OffsetDateTime getReservationDate() {
    return reservationDate;
  }

  public void setReservationDate(OffsetDateTime reservationDate) {
    this.reservationDate = reservationDate;
  }

  public Comment reservationEmail(String reservationEmail) {
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

  public Comment reservationInfoId(Integer reservationInfoId) {
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

  public Comment reservationName(String reservationName) {
    this.reservationName = reservationName;
    return this;
  }

  /**
   * 예약자 명
   * @return reservationName
  **/
  @ApiModelProperty(value = "예약자 명")


  public String getReservationName() {
    return reservationName;
  }

  public void setReservationName(String reservationName) {
    this.reservationName = reservationName;
  }

  public Comment reservationTelephone(String reservationTelephone) {
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

  public Comment score(Double score) {
    this.score = score;
    return this;
  }

  /**
   * 평점
   * @return score
  **/
  @ApiModelProperty(value = "평점")


  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Comment comment = (Comment) o;
    return Objects.equals(this.comment, comment.comment) &&
        Objects.equals(this.commentId, comment.commentId) &&
        Objects.equals(this.commentImages, comment.commentImages) &&
        Objects.equals(this.createDate, comment.createDate) &&
        Objects.equals(this.modifyDate, comment.modifyDate) &&
        Objects.equals(this.productId, comment.productId) &&
        Objects.equals(this.reservationDate, comment.reservationDate) &&
        Objects.equals(this.reservationEmail, comment.reservationEmail) &&
        Objects.equals(this.reservationInfoId, comment.reservationInfoId) &&
        Objects.equals(this.reservationName, comment.reservationName) &&
        Objects.equals(this.reservationTelephone, comment.reservationTelephone) &&
        Objects.equals(this.score, comment.score);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comment, commentId, commentImages, createDate, modifyDate, productId, reservationDate, reservationEmail, reservationInfoId, reservationName, reservationTelephone, score);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Comment {\n");
    
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    commentId: ").append(toIndentedString(commentId)).append("\n");
    sb.append("    commentImages: ").append(toIndentedString(commentImages)).append("\n");
    sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
    sb.append("    modifyDate: ").append(toIndentedString(modifyDate)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    reservationDate: ").append(toIndentedString(reservationDate)).append("\n");
    sb.append("    reservationEmail: ").append(toIndentedString(reservationEmail)).append("\n");
    sb.append("    reservationInfoId: ").append(toIndentedString(reservationInfoId)).append("\n");
    sb.append("    reservationName: ").append(toIndentedString(reservationName)).append("\n");
    sb.append("    reservationTelephone: ").append(toIndentedString(reservationTelephone)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
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

