package com.ikth.apps.reservation.dto;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 상품평 이미지
 */
@ApiModel(description = "상품평 이미지")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-05T12:37:37.915+09:00")

public class CommentImage   {
  @JsonProperty("contentType")
  private String contentType = null;

  @JsonProperty("createDate")
  private OffsetDateTime createDate = null;

  @JsonProperty("deleteFlag")
  private Boolean deleteFlag = null;

  @JsonProperty("fileId")
  private Integer fileId = null;

  @JsonProperty("fileName")
  private String fileName = null;

  @JsonProperty("imageId")
  private Integer imageId = null;

  @JsonProperty("modifyDate")
  private OffsetDateTime modifyDate = null;

  @JsonProperty("reservationInfoId")
  private Integer reservationInfoId = null;

  @JsonProperty("reservationUserCommentId")
  private Integer reservationUserCommentId = null;

  @JsonProperty("saveFileName")
  private String saveFileName = null;

  public CommentImage contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  /**
   * 파일 확장자
   * @return contentType
  **/
  @ApiModelProperty(value = "파일 확장자")


  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public CommentImage createDate(OffsetDateTime createDate) {
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

  public CommentImage deleteFlag(Boolean deleteFlag) {
    this.deleteFlag = deleteFlag;
    return this;
  }

  /**
   * 삭제 여부
   * @return deleteFlag
  **/
  @ApiModelProperty(value = "삭제 여부")


  public Boolean isDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(Boolean deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public CommentImage fileId(Integer fileId) {
    this.fileId = fileId;
    return this;
  }

  /**
   * 파일 id
   * @return fileId
  **/
  @ApiModelProperty(value = "파일 id")


  public Integer getFileId() {
    return fileId;
  }

  public void setFileId(Integer fileId) {
    this.fileId = fileId;
  }

  public CommentImage fileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  /**
   * 파일 이름
   * @return fileName
  **/
  @ApiModelProperty(value = "파일 이름")


  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public CommentImage imageId(Integer imageId) {
    this.imageId = imageId;
    return this;
  }

  /**
   * 이미지 Id
   * @return imageId
  **/
  @ApiModelProperty(value = "이미지 Id")


  public Integer getImageId() {
    return imageId;
  }

  public void setImageId(Integer imageId) {
    this.imageId = imageId;
  }

  public CommentImage modifyDate(OffsetDateTime modifyDate) {
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

  public CommentImage reservationInfoId(Integer reservationInfoId) {
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

  public CommentImage reservationUserCommentId(Integer reservationUserCommentId) {
    this.reservationUserCommentId = reservationUserCommentId;
    return this;
  }

  /**
   * 예약자 상품평 Id
   * @return reservationUserCommentId
  **/
  @ApiModelProperty(value = "예약자 상품평 Id")


  public Integer getReservationUserCommentId() {
    return reservationUserCommentId;
  }

  public void setReservationUserCommentId(Integer reservationUserCommentId) {
    this.reservationUserCommentId = reservationUserCommentId;
  }

  public CommentImage saveFileName(String saveFileName) {
    this.saveFileName = saveFileName;
    return this;
  }

  /**
   * 파일 저장 위치 이름
   * @return saveFileName
  **/
  @ApiModelProperty(value = "파일 저장 위치 이름")


  public String getSaveFileName() {
    return saveFileName;
  }

  public void setSaveFileName(String saveFileName) {
    this.saveFileName = saveFileName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentImage commentImage = (CommentImage) o;
    return Objects.equals(this.contentType, commentImage.contentType) &&
        Objects.equals(this.createDate, commentImage.createDate) &&
        Objects.equals(this.deleteFlag, commentImage.deleteFlag) &&
        Objects.equals(this.fileId, commentImage.fileId) &&
        Objects.equals(this.fileName, commentImage.fileName) &&
        Objects.equals(this.imageId, commentImage.imageId) &&
        Objects.equals(this.modifyDate, commentImage.modifyDate) &&
        Objects.equals(this.reservationInfoId, commentImage.reservationInfoId) &&
        Objects.equals(this.reservationUserCommentId, commentImage.reservationUserCommentId) &&
        Objects.equals(this.saveFileName, commentImage.saveFileName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentType, createDate, deleteFlag, fileId, fileName, imageId, modifyDate, reservationInfoId, reservationUserCommentId, saveFileName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentImage {\n");
    
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
    sb.append("    deleteFlag: ").append(toIndentedString(deleteFlag)).append("\n");
    sb.append("    fileId: ").append(toIndentedString(fileId)).append("\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    imageId: ").append(toIndentedString(imageId)).append("\n");
    sb.append("    modifyDate: ").append(toIndentedString(modifyDate)).append("\n");
    sb.append("    reservationInfoId: ").append(toIndentedString(reservationInfoId)).append("\n");
    sb.append("    reservationUserCommentId: ").append(toIndentedString(reservationUserCommentId)).append("\n");
    sb.append("    saveFileName: ").append(toIndentedString(saveFileName)).append("\n");
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

