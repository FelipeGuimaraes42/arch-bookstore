package com.felipeguimaraes42.archbookstore.clean.usecases.gateways;

import com.felipeguimaraes42.archbookstore.clean.adapters.mappers.BookDataMapper;
import java.util.List;

public interface BookGateway {
  List<BookDataMapper> findAll();
}
