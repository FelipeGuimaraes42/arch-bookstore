package com.felipeguimaraes42.archbookstore.bbom.services;

import com.felipeguimaraes42.archbookstore.bbom.domains.HortifrutiCart;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HortifrutiCartService {
  public Double execute(final List<HortifrutiCart> hortifrutiCartList) {
    double sum = 0.0;

    for (HortifrutiCart hortifrutiCart : hortifrutiCartList) {
      sum += hortifrutiCart.getHortifruti().getPrice() * hortifrutiCart.getQuantity();
    }

    return sum;
  }
}
