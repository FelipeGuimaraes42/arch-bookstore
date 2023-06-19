package com.felipeguimaraes42.archbookstore.clean.usecases.presenters;

import com.felipeguimaraes42.archbookstore.clean.usecases.models.hortifruti.HortifrutiResponseModel;
import java.util.List;

public interface HortifrutiPresenter {
  List<HortifrutiResponseModel> prepareSuccessView(final List<HortifrutiResponseModel> hortifruti);
}
