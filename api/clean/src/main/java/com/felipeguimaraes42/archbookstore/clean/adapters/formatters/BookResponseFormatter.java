package com.felipeguimaraes42.archbookstore.clean.adapters.formatters;

import com.felipeguimaraes42.archbookstore.clean.usecases.models.book.BookResponseModel;
import com.felipeguimaraes42.archbookstore.clean.usecases.presenters.BookPresenter;
import java.util.List;

public class BookResponseFormatter implements BookPresenter {

  @Override
  public List<BookResponseModel> prepareSuccessView(final List<BookResponseModel> books) {
    return books;
  }
}
