package com.felipeguimaraes42.architecturehortifruti.clean.entities.hortifruti;

public interface HortifrutiFactory {
  Hortifruti create(
      final String name,
      final String description,
      final Double price,
      final String category,
      final String image);
}
