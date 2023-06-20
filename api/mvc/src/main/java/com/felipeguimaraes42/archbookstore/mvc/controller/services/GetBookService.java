package com.felipeguimaraes42.archbookstore.mvc.controller.services;

import com.felipeguimaraes42.archbookstore.mvc.controller.dtos.BookDTO;
import com.felipeguimaraes42.archbookstore.mvc.controller.entities.BookEntity;
import com.felipeguimaraes42.archbookstore.mvc.controller.mappers.BookMapper;
import com.felipeguimaraes42.archbookstore.mvc.controller.repositories.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GetBookService {
  private final BookRepository bookRepository;

  public GetBookService(final BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<BookDTO> getAll() {
    return BookMapper.INSTANCE.toBookDTOs(bookRepository.findAll());
  }

  public BookEntity getOneById(final Long id) {
    Optional<BookEntity> optionalBook = bookRepository.findById(id);
    return optionalBook.orElse(null);
  }

  public List<BookEntity> searchByName(final String query) {
    return bookRepository.findByTitle(query.toUpperCase());
  }
}
