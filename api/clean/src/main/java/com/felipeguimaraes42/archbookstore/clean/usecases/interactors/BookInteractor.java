package com.felipeguimaraes42.archbookstore.clean.usecases.interactors;

import com.felipeguimaraes42.archbookstore.clean.adapters.mappers.BookDataMapper;
import com.felipeguimaraes42.archbookstore.clean.usecases.boundaries.BookBoundary;
import com.felipeguimaraes42.archbookstore.clean.usecases.gateways.BookGateway;
import com.felipeguimaraes42.archbookstore.clean.usecases.models.book.BookResponseModel;
import com.felipeguimaraes42.archbookstore.clean.usecases.presenters.BookPresenter;
import java.util.ArrayList;
import java.util.List;

public class BookInteractor implements BookBoundary {
  private final BookPresenter presenter;
  private final BookGateway gateway;

  public BookInteractor(final BookPresenter presenter, final BookGateway gateway) {
    this.presenter = presenter;
    this.gateway = gateway;
  }

  @Override
  public List<BookResponseModel> getAll() {
    final List<BookDataMapper> bookFromDatabase = gateway.findAll();
    List<BookResponseModel> books = new ArrayList<>();
    bookFromDatabase.forEach(
        book -> {
          final var bookResponseModel =
              new BookResponseModel(
                  book.getId(),
                  book.getTitle(),
                  book.getAuthor(),
                  book.getSynopsis(),
                  book.getCategory(),
                  book.getImage(),
                  book.getPrice());
          books.add(bookResponseModel);
        });
    return presenter.prepareSuccessView(books);
  }
}
