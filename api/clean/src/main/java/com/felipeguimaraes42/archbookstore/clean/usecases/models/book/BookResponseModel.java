package com.felipeguimaraes42.archbookstore.clean.usecases.models.book;

public class BookResponseModel {
  private Long id;
  private String title;
  private String author;
  private String synopsis;
  private String category;
  private String image;
  private Double price;

  public BookResponseModel() {}

  public BookResponseModel(
      final Long id,
      final String title,
      final String author,
      final String synopsis,
      final String category,
      final String image,
      final Double price) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.synopsis = synopsis;
    this.category = category;
    this.image = image;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(final String author) {
    this.author = author;
  }

  public String getSynopsis() {
    return synopsis;
  }

  public void setSynopsis(final String synopsis) {
    this.synopsis = synopsis;
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

  public Double getPrice() {
    return price;
  }

  public void setPrice(final Double price) {
    this.price = price;
  }
}
