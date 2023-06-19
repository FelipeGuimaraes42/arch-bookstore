package com.felipeguimaraes42.archbookstore.clean.usecases.boundaries;

import com.felipeguimaraes42.archbookstore.clean.usecases.models.hortifruti.HortifrutiResponseModel;
import java.util.List;

public interface HortifrutiBoundary {
  List<HortifrutiResponseModel> getAll();
}
