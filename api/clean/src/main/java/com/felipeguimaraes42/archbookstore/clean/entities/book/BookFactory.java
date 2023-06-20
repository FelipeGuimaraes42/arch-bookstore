package com.felipeguimaraes42.archbookstore.clean.entities.book;

public interface BookFactory {
  Book create(
      final String title,
      final String author,
      final String synopsis,
      final String category,
      final String image,
      final Double price);
}
