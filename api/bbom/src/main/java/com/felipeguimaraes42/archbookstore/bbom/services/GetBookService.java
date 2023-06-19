package com.felipeguimaraes42.archbookstore.bbom.services;

import com.felipeguimaraes42.archbookstore.bbom.domains.Book;
import com.felipeguimaraes42.archbookstore.bbom.repositories.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GetBookService {

  private final BookRepository bookRepository;

  public GetBookService(final BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> getAll() {
    return bookRepository.findAll();
  }

  public Book getOne(final Long id) {
    Optional<Book> optionalBook = bookRepository.findById(id);
    return optionalBook.orElse(null);
  }

  public List<Book> searchByName(final String query) {
    return bookRepository.findByName(query.toUpperCase());
  }
}
