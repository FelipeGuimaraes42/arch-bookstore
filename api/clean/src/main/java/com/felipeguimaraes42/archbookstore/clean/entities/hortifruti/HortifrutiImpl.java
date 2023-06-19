package com.felipeguimaraes42.archbookstore.clean.entities.hortifruti;

public class HortifrutiImpl implements Hortifruti {
  private String name;

  private String description;

  private Double price;
  private String category;

  private String image;

  public HortifrutiImpl() {}

  public HortifrutiImpl(
      final String name,
      final String description,
      final Double price,
      final String category,
      final String image) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.category = category;
    this.image = image;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public Double getPrice() {
    return price;
  }

  @Override
  public String getCategory() {
    return category;
  }

  @Override
  public String getImage() {
    return image;
  }
}
