package com.felipeguimaraes42.architecturehortifruti.clean.usecases.presenters;

import com.felipeguimaraes42.architecturehortifruti.clean.usecases.models.hortifruti.HortifrutiResponseModel;
import java.util.List;

public interface HortifrutiPresenter {
  List<HortifrutiResponseModel> prepareSuccessView(final List<HortifrutiResponseModel> hortifruti);
}
