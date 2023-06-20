package com.felipeguimaraes42.archbookstore.clean.entities.book;

public class BookImpl implements Book {
  private String title;
  private String author;
  private String synopsis;
  private String category;
  private String image;
  private Double price;

  public BookImpl() {}

  public BookImpl(
      final String title,
      final String author,
      final String synopsis,
      final String category,
      final String image,
      final Double price) {
    this.title = title;
    this.author = author;
    this.synopsis = synopsis;
    this.category = category;
    this.image = image;
    this.price = price;
  }

  @Override
  public String getTitle() {
    return this.title;
  }

  @Override
  public String getAuthor() {
    return this.author;
  }

  @Override
  public String getSynopsis() {
    return this.synopsis;
  }

  @Override
  public String getCategory() {
    return this.category;
  }

  @Override
  public String getImage() {
    return this.image;
  }

  @Override
  public Double getPrice() {
    return this.price;
  }
}
