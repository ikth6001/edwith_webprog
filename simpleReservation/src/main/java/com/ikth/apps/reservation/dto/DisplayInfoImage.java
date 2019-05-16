package com.ikth.apps.reservation.dto;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 전시 이미지
 */
@ApiModel(description = "전시 이미지")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-05T12:37:37.915+09:00")

public class DisplayInfoImage   {
  @JsonProperty("contentType")
  private String contentType = null;

  @JsonProperty("createDate")
  private OffsetDateTime createDate = null;

  @JsonProperty("deleteFlag")
  private Boolean deleteFlag = null;

  @JsonProperty("displayInfoId")
  private Integer displayInfoId = null;

  @JsonProperty("displayInfoImageId")
  private Integer displayInfoImageId = null;

  @JsonProperty("fileId")
  private Integer fileId = null;

  @JsonProperty("fileName")
  private String fileName = null;

  @JsonProperty("modifyDate")
  private OffsetDateTime modifyDate = null;

  @JsonProperty("saveFileName")
  private String saveFileName = null;

  public DisplayInfoImage contentType(String contentType) {
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

  public DisplayInfoImage createDate(OffsetDateTime createDate) {
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

  public DisplayInfoImage deleteFlag(Boolean deleteFlag) {
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

  public DisplayInfoImage displayInfoId(Integer displayInfoId) {
    this.displayInfoId = displayInfoId;
    return this;
  }

  /**
   * 전시 Id
   * @return displayInfoId
  **/
  @ApiModelProperty(value = "전시 Id")


  public Integer getDisplayInfoId() {
    return displayInfoId;
  }

  public void setDisplayInfoId(Integer displayInfoId) {
    this.displayInfoId = displayInfoId;
  }

  public DisplayInfoImage displayInfoImageId(Integer displayInfoImageId) {
    this.displayInfoImageId = displayInfoImageId;
    return this;
  }

  /**
   * 전시 이미지 Id
   * @return displayInfoImageId
  **/
  @ApiModelProperty(value = "전시 이미지 Id")


  public Integer getDisplayInfoImageId() {
    return displayInfoImageId;
  }

  public void setDisplayInfoImageId(Integer displayInfoImageId) {
    this.displayInfoImageId = displayInfoImageId;
  }

  public DisplayInfoImage fileId(Integer fileId) {
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

  public DisplayInfoImage fileName(String fileName) {
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

  public DisplayInfoImage modifyDate(OffsetDateTime modifyDate) {
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

  public DisplayInfoImage saveFileName(String saveFileName) {
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
    DisplayInfoImage displayInfoImage = (DisplayInfoImage) o;
    return Objects.equals(this.contentType, displayInfoImage.contentType) &&
        Objects.equals(this.createDate, displayInfoImage.createDate) &&
        Objects.equals(this.deleteFlag, displayInfoImage.deleteFlag) &&
        Objects.equals(this.displayInfoId, displayInfoImage.displayInfoId) &&
        Objects.equals(this.displayInfoImageId, displayInfoImage.displayInfoImageId) &&
        Objects.equals(this.fileId, displayInfoImage.fileId) &&
        Objects.equals(this.fileName, displayInfoImage.fileName) &&
        Objects.equals(this.modifyDate, displayInfoImage.modifyDate) &&
        Objects.equals(this.saveFileName, displayInfoImage.saveFileName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentType, createDate, deleteFlag, displayInfoId, displayInfoImageId, fileId, fileName, modifyDate, saveFileName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DisplayInfoImage {\n");
    
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
    sb.append("    deleteFlag: ").append(toIndentedString(deleteFlag)).append("\n");
    sb.append("    displayInfoId: ").append(toIndentedString(displayInfoId)).append("\n");
    sb.append("    displayInfoImageId: ").append(toIndentedString(displayInfoImageId)).append("\n");
    sb.append("    fileId: ").append(toIndentedString(fileId)).append("\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    modifyDate: ").append(toIndentedString(modifyDate)).append("\n");
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

