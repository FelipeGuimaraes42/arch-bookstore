package com.felipeguimaraes42.architecturehortifruti.clean.usecases.boundaries;

import com.felipeguimaraes42.architecturehortifruti.clean.usecases.models.hortifruti.HortifrutiResponseModel;
import java.util.List;

public interface HortifrutiBoundary {
  List<HortifrutiResponseModel> getAll();
}
