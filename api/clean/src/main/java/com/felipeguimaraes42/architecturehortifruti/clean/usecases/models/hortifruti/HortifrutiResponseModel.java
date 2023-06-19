package com.felipeguimaraes42.architecturehortifruti.clean.usecases.models.hortifruti;

public class HortifrutiResponseModel {
  private Long id;
  private String name;

  private String description;

  private Double price;
  private String category;

  private String image;

  public HortifrutiResponseModel() {}

  public HortifrutiResponseModel(
      final Long id,
      final String name,
      final String description,
      final Double price,
      final String category,
      final String image) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.category = category;
    this.image = image;
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(final Double price) {
    this.price = price;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(final String category) {
    this.category = category;
  }

  public String getImage() {
    return image;
  }

  public void setImage(final String image) {
    this.image = image;
  }
}
