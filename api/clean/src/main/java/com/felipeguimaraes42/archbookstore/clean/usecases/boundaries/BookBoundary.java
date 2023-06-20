package com.felipeguimaraes42.archbookstore.clean.usecases.boundaries;

import com.felipeguimaraes42.archbookstore.clean.usecases.models.book.BookResponseModel;
import java.util.List;

public interface BookBoundary {
  List<BookResponseModel> getAll();
}
