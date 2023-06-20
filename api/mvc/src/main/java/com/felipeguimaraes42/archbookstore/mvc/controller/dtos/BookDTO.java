package com.felipeguimaraes42.archbookstore.mvc.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookDTO {
  private Long id;
  private String title;
  private String author;
  private String synopsis;
  private String category;
  private String image;
  private Double price;
}
