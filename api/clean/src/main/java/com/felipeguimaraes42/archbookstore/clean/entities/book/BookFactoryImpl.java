package com.felipeguimaraes42.archbookstore.clean.entities.book;

public class BookFactoryImpl implements BookFactory {

  @Override
  public Book create(
      final String title,
      final String author,
      final String synopsis,
      final String category,
      final String image,
      final Double price) {
    return new BookImpl(title, author, synopsis, category, image, price);
  }
}
