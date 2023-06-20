package com.felipeguimaraes42.archbookstore.clean.adapters.repositories.hortifruti;

import com.felipeguimaraes42.archbookstore.clean.adapters.mappers.BookDataMapper;
import com.felipeguimaraes42.archbookstore.clean.usecases.gateways.BookGateway;
import java.util.List;

public class BookRepository implements BookGateway {
  private final JpaBookRepository repository;

  public BookRepository(final JpaBookRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<BookDataMapper> findAll() {
    return repository.findAll();
  }
}
