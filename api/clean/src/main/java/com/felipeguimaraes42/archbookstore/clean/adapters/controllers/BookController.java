package com.felipeguimaraes42.archbookstore.clean.adapters.controllers;

import com.felipeguimaraes42.archbookstore.clean.usecases.boundaries.BookBoundary;
import com.felipeguimaraes42.archbookstore.clean.usecases.models.book.BookResponseModel;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("book")
public class BookController {
  private final BookBoundary bookBoundary;

  public BookController(final BookBoundary bookBoundary) {
    this.bookBoundary = bookBoundary;
  }

  @GetMapping("/")
  public ResponseEntity<List<BookResponseModel>> getAll() {
    return new ResponseEntity<>(bookBoundary.getAll(), HttpStatus.OK);
  }
}
