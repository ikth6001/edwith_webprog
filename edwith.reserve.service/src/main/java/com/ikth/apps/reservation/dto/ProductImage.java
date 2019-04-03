package com.ikth.apps.reservation.dto;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 상품 이미지 모델
 */
@ApiModel(description = "상품 이미지 모델")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-05T12:37:37.915+09:00")

public class ProductImage   {
  @JsonProperty("contentType")
  private String contentType = null;

  @JsonProperty("createDate")
  private OffsetDateTime createDate = null;

  @JsonProperty("deleteFlag")
  private Boolean deleteFlag = null;

  @JsonProperty("fileInfoId")
  private Integer fileInfoId = null;

  @JsonProperty("fileName")
  private String fileName = null;

  @JsonProperty("modifyDate")
  private OffsetDateTime modifyDate = null;

  @JsonProperty("productId")
  private Integer productId = null;

  @JsonProperty("productImageId")
  private Integer productImageId = null;

  @JsonProperty("saveFileName")
  private String saveFileName = null;

  /**
   * 이미지 타입 (main, thumbnail, etc)
   */
  public enum TypeEnum {
    MA("ma"),
    
    TH("th"),
    
    ET("et");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }
    
    public String getValue() {
		return value;
	}

	@JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("type")
  private TypeEnum type = null;

  public ProductImage contentType(String contentType) {
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

  public ProductImage createDate(OffsetDateTime createDate) {
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

  public ProductImage deleteFlag(Boolean deleteFlag) {
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

  public ProductImage fileInfoId(Integer fileInfoId) {
    this.fileInfoId = fileInfoId;
    return this;
  }

  /**
   * 파일 Id
   * @return fileInfoId
  **/
  @ApiModelProperty(value = "파일 Id")


  public Integer getFileInfoId() {
    return fileInfoId;
  }

  public void setFileInfoId(Integer fileInfoId) {
    this.fileInfoId = fileInfoId;
  }

  public ProductImage fileName(String fileName) {
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

  public ProductImage modifyDate(OffsetDateTime modifyDate) {
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

  public ProductImage productId(Integer productId) {
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

  public ProductImage productImageId(Integer productImageId) {
    this.productImageId = productImageId;
    return this;
  }

  /**
   * 상품 이미지 Id
   * @return productImageId
  **/
  @ApiModelProperty(value = "상품 이미지 Id")


  public Integer getProductImageId() {
    return productImageId;
  }

  public void setProductImageId(Integer productImageId) {
    this.productImageId = productImageId;
  }

  public ProductImage saveFileName(String saveFileName) {
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

  public ProductImage type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * 이미지 타입 (main, thumbnail, etc)
   * @return type
  **/
  @ApiModelProperty(value = "이미지 타입 (main, thumbnail, etc)")


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductImage productImage = (ProductImage) o;
    return Objects.equals(this.contentType, productImage.contentType) &&
        Objects.equals(this.createDate, productImage.createDate) &&
        Objects.equals(this.deleteFlag, productImage.deleteFlag) &&
        Objects.equals(this.fileInfoId, productImage.fileInfoId) &&
        Objects.equals(this.fileName, productImage.fileName) &&
        Objects.equals(this.modifyDate, productImage.modifyDate) &&
        Objects.equals(this.productId, productImage.productId) &&
        Objects.equals(this.productImageId, productImage.productImageId) &&
        Objects.equals(this.saveFileName, productImage.saveFileName) &&
        Objects.equals(this.type, productImage.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentType, createDate, deleteFlag, fileInfoId, fileName, modifyDate, productId, productImageId, saveFileName, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductImage {\n");
    
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
    sb.append("    deleteFlag: ").append(toIndentedString(deleteFlag)).append("\n");
    sb.append("    fileInfoId: ").append(toIndentedString(fileInfoId)).append("\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    modifyDate: ").append(toIndentedString(modifyDate)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    productImageId: ").append(toIndentedString(productImageId)).append("\n");
    sb.append("    saveFileName: ").append(toIndentedString(saveFileName)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

