package com.felipeguimaraes42.archbookstore.bbom.controllers;

import com.felipeguimaraes42.archbookstore.bbom.domains.Book;
import com.felipeguimaraes42.archbookstore.bbom.domains.BookCart;
import com.felipeguimaraes42.archbookstore.bbom.services.BookCartService;
import com.felipeguimaraes42.archbookstore.bbom.services.GetBookService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
@CrossOrigin
public class BookController {
  private final GetBookService getBookService;
  private final BookCartService bookCartService;

  public BookController(
      final GetBookService getBookService, final BookCartService bookCartService) {
    this.getBookService = getBookService;
    this.bookCartService = bookCartService;
  }

  @GetMapping("/")
  public ResponseEntity<List<Book>> getAllBooks() {
    return new ResponseEntity<>(getBookService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/item")
  public ResponseEntity<Book> getOneBook(@RequestParam final Long id) {
    return new ResponseEntity<>(getBookService.getOne(id), HttpStatus.OK);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Book>> getBooksByName(@RequestParam final String query) {
    return new ResponseEntity<>(getBookService.searchByName(query), HttpStatus.OK);
  }

  @PostMapping("/cart")
  public ResponseEntity<Double> getCartValue(@RequestBody final List<BookCart> bookCartList) {
    return new ResponseEntity<>(bookCartService.execute(bookCartList), HttpStatus.OK);
  }
}
