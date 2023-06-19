package com.felipeguimaraes42.archbookstore.bbom.services;

import com.felipeguimaraes42.archbookstore.bbom.domains.BookCart;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookCartService {
  public Double execute(final List<BookCart> bookCartList) {
    double sum = 0.0;

    for (BookCart bookCart : bookCartList) {
      sum += bookCart.getBook().getPrice() * bookCart.getQuantity();
    }

    return sum;
  }
}
