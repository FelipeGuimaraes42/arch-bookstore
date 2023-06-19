package com.felipeguimaraes42.architecturehortifruti.none.services;

import com.felipeguimaraes42.architecturehortifruti.none.domains.HortifrutiCart;
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
