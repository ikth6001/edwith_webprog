package com.ikth.apps.reservation.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DisplayInfoResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-05T12:37:37.915+09:00")

public class DisplayInfoResponse   {
  @JsonProperty("averageScore")
  private Double averageScore = null;

  @JsonProperty("comments")
  @Valid
  private List<Comment> comments = null;

  @JsonProperty("displayInfo")
  private DisplayInfo displayInfo = null;

  @JsonProperty("displayInfoImage")
  private DisplayInfoImage displayInfoImage = null;

  @JsonProperty("productImages")
  @Valid
  private List<ProductImage> productImages = null;

  @JsonProperty("productPrices")
  @Valid
  private List<ProductPrice> productPrices = null;

  public DisplayInfoResponse averageScore(Double averageScore) {
    this.averageScore = averageScore;
    return this;
  }

  /**
   * Get averageScore
   * @return averageScore
  **/
  @ApiModelProperty(value = "")


  public Double getAverageScore() {
    return averageScore;
  }

  public void setAverageScore(Double averageScore) {
    this.averageScore = averageScore;
  }

  public DisplayInfoResponse comments(List<Comment> comments) {
    this.comments = comments;
    return this;
  }

  public DisplayInfoResponse addCommentsItem(Comment commentsItem) {
    if (this.comments == null) {
      this.comments = new ArrayList<Comment>();
    }
    this.comments.add(commentsItem);
    return this;
  }

  /**
   * Get comments
   * @return comments
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  public DisplayInfoResponse displayInfo(DisplayInfo displayInfo) {
    this.displayInfo = displayInfo;
    return this;
  }

  /**
   * Get displayInfo
   * @return displayInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public DisplayInfo getDisplayInfo() {
    return displayInfo;
  }

  public void setDisplayInfo(DisplayInfo displayInfo) {
    this.displayInfo = displayInfo;
  }

  public DisplayInfoResponse displayInfoImage(DisplayInfoImage displayInfoImage) {
    this.displayInfoImage = displayInfoImage;
    return this;
  }

  /**
   * Get displayInfoImage
   * @return displayInfoImage
  **/
  @ApiModelProperty(value = "")

  @Valid

  public DisplayInfoImage getDisplayInfoImage() {
    return displayInfoImage;
  }

  public void setDisplayInfoImage(DisplayInfoImage displayInfoImage) {
    this.displayInfoImage = displayInfoImage;
  }

  public DisplayInfoResponse productImages(List<ProductImage> productImages) {
    this.productImages = productImages;
    return this;
  }

  public DisplayInfoResponse addProductImagesItem(ProductImage productImagesItem) {
    if (this.productImages == null) {
      this.productImages = new ArrayList<ProductImage>();
    }
    this.productImages.add(productImagesItem);
    return this;
  }

  /**
   * Get productImages
   * @return productImages
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ProductImage> getProductImages() {
    return productImages;
  }

  public void setProductImages(List<ProductImage> productImages) {
    this.productImages = productImages;
  }

  public DisplayInfoResponse productPrices(List<ProductPrice> productPrices) {
    this.productPrices = productPrices;
    return this;
  }

  public DisplayInfoResponse addProductPricesItem(ProductPrice productPricesItem) {
    if (this.productPrices == null) {
      this.productPrices = new ArrayList<ProductPrice>();
    }
    this.productPrices.add(productPricesItem);
    return this;
  }

  /**
   * Get productPrices
   * @return productPrices
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ProductPrice> getProductPrices() {
    return productPrices;
  }

  public void setProductPrices(List<ProductPrice> productPrices) {
    this.productPrices = productPrices;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DisplayInfoResponse displayInfoResponse = (DisplayInfoResponse) o;
    return Objects.equals(this.averageScore, displayInfoResponse.averageScore) &&
        Objects.equals(this.comments, displayInfoResponse.comments) &&
        Objects.equals(this.displayInfo, displayInfoResponse.displayInfo) &&
        Objects.equals(this.displayInfoImage, displayInfoResponse.displayInfoImage) &&
        Objects.equals(this.productImages, displayInfoResponse.productImages) &&
        Objects.equals(this.productPrices, displayInfoResponse.productPrices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(averageScore, comments, displayInfo, displayInfoImage, productImages, productPrices);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DisplayInfoResponse {\n");
    
    sb.append("    averageScore: ").append(toIndentedString(averageScore)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    displayInfo: ").append(toIndentedString(displayInfo)).append("\n");
    sb.append("    displayInfoImage: ").append(toIndentedString(displayInfoImage)).append("\n");
    sb.append("    productImages: ").append(toIndentedString(productImages)).append("\n");
    sb.append("    productPrices: ").append(toIndentedString(productPrices)).append("\n");
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

