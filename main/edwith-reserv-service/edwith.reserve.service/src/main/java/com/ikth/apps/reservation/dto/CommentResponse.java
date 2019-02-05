package com.ikth.apps.reservation.dto;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 한줄평 등록 response 모델
 */
@ApiModel(description = "한줄평 등록 response 모델")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-05T12:37:37.915+09:00")

public class CommentResponse   {
  @JsonProperty("comment")
  private String comment = null;

  @JsonProperty("commentId")
  private Integer commentId = null;

  @JsonProperty("commentImage")
  private CommentImage commentImage = null;

  @JsonProperty("createDate")
  private OffsetDateTime createDate = null;

  @JsonProperty("modifyDate")
  private OffsetDateTime modifyDate = null;

  @JsonProperty("productId")
  private Integer productId = null;

  @JsonProperty("reservationInfoId")
  private Integer reservationInfoId = null;

  @JsonProperty("score")
  private Integer score = null;

  public CommentResponse comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * 평
   * @return comment
  **/
  @ApiModelProperty(value = "평")


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public CommentResponse commentId(Integer commentId) {
    this.commentId = commentId;
    return this;
  }

  /**
   * 한줄평 Id
   * @return commentId
  **/
  @ApiModelProperty(value = "한줄평 Id")


  public Integer getCommentId() {
    return commentId;
  }

  public void setCommentId(Integer commentId) {
    this.commentId = commentId;
  }

  public CommentResponse commentImage(CommentImage commentImage) {
    this.commentImage = commentImage;
    return this;
  }

  /**
   * 한줄평 첨부 이미지
   * @return commentImage
  **/
  @ApiModelProperty(value = "한줄평 첨부 이미지")

  @Valid

  public CommentImage getCommentImage() {
    return commentImage;
  }

  public void setCommentImage(CommentImage commentImage) {
    this.commentImage = commentImage;
  }

  public CommentResponse createDate(OffsetDateTime createDate) {
    this.createDate = createDate;
    return this;
  }

  /**
   * 등록일
   * @return createDate
  **/
  @ApiModelProperty(value = "등록일")

  @Valid

  public OffsetDateTime getCreateDate() {
    return createDate;
  }

  public void setCreateDate(OffsetDateTime createDate) {
    this.createDate = createDate;
  }

  public CommentResponse modifyDate(OffsetDateTime modifyDate) {
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

  public CommentResponse productId(Integer productId) {
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

  public CommentResponse reservationInfoId(Integer reservationInfoId) {
    this.reservationInfoId = reservationInfoId;
    return this;
  }

  /**
   * 예약정보 Id
   * @return reservationInfoId
  **/
  @ApiModelProperty(value = "예약정보 Id")


  public Integer getReservationInfoId() {
    return reservationInfoId;
  }

  public void setReservationInfoId(Integer reservationInfoId) {
    this.reservationInfoId = reservationInfoId;
  }

  public CommentResponse score(Integer score) {
    this.score = score;
    return this;
  }

  /**
   * 별점
   * @return score
  **/
  @ApiModelProperty(value = "별점")


  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
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
    CommentResponse commentResponse = (CommentResponse) o;
    return Objects.equals(this.comment, commentResponse.comment) &&
        Objects.equals(this.commentId, commentResponse.commentId) &&
        Objects.equals(this.commentImage, commentResponse.commentImage) &&
        Objects.equals(this.createDate, commentResponse.createDate) &&
        Objects.equals(this.modifyDate, commentResponse.modifyDate) &&
        Objects.equals(this.productId, commentResponse.productId) &&
        Objects.equals(this.reservationInfoId, commentResponse.reservationInfoId) &&
        Objects.equals(this.score, commentResponse.score);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comment, commentId, commentImage, createDate, modifyDate, productId, reservationInfoId, score);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentResponse {\n");
    
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    commentId: ").append(toIndentedString(commentId)).append("\n");
    sb.append("    commentImage: ").append(toIndentedString(commentImage)).append("\n");
    sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
    sb.append("    modifyDate: ").append(toIndentedString(modifyDate)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    reservationInfoId: ").append(toIndentedString(reservationInfoId)).append("\n");
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

