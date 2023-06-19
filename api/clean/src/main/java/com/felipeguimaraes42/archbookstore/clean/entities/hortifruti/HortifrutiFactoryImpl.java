package com.felipeguimaraes42.archbookstore.clean.entities.hortifruti;

public class HortifrutiFactoryImpl implements HortifrutiFactory {

  @Override
  public Hortifruti create(
      final String name,
      final String description,
      final Double price,
      final String category,
      final String image) {
    return new HortifrutiImpl(name, description, price, category, image);
  }
}
