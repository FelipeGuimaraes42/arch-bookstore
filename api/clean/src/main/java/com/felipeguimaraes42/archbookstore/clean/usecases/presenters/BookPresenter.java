package com.felipeguimaraes42.archbookstore.clean.usecases.presenters;

import com.felipeguimaraes42.archbookstore.clean.usecases.models.book.BookResponseModel;
import java.util.List;

public interface BookPresenter {
  List<BookResponseModel> prepareSuccessView(final List<BookResponseModel> hortifruti);
}
