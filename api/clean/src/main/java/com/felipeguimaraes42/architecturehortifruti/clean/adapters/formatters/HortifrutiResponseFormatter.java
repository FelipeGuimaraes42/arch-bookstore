package com.felipeguimaraes42.architecturehortifruti.clean.adapters.formatters;

import com.felipeguimaraes42.architecturehortifruti.clean.usecases.models.hortifruti.HortifrutiResponseModel;
import com.felipeguimaraes42.architecturehortifruti.clean.usecases.presenters.HortifrutiPresenter;
import java.util.List;

public class HortifrutiResponseFormatter implements HortifrutiPresenter {

  @Override
  public List<HortifrutiResponseModel> prepareSuccessView(
      final List<HortifrutiResponseModel> hortifruti) {
    return hortifruti;
  }
}
