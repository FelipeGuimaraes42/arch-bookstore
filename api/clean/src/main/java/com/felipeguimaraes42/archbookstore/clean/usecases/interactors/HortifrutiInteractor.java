package com.felipeguimaraes42.archbookstore.clean.usecases.interactors;

import com.felipeguimaraes42.archbookstore.clean.adapters.mappers.HortifrutiDataMapper;
import com.felipeguimaraes42.archbookstore.clean.usecases.boundaries.HortifrutiBoundary;
import com.felipeguimaraes42.archbookstore.clean.usecases.gateways.HortifrutiGateway;
import com.felipeguimaraes42.archbookstore.clean.usecases.models.hortifruti.HortifrutiResponseModel;
import com.felipeguimaraes42.archbookstore.clean.usecases.presenters.HortifrutiPresenter;
import java.util.ArrayList;
import java.util.List;

public class HortifrutiInteractor implements HortifrutiBoundary {
  private final HortifrutiPresenter presenter;
  private final HortifrutiGateway gateway;

  public HortifrutiInteractor(
      final HortifrutiPresenter presenter, final HortifrutiGateway gateway) {
    this.presenter = presenter;
    this.gateway = gateway;
  }

  @Override
  public List<HortifrutiResponseModel> getAll() {
    final List<HortifrutiDataMapper> hortifrutiFromDatabase = gateway.findAll();
    List<HortifrutiResponseModel> responseHortifruti = new ArrayList<>();
    hortifrutiFromDatabase.forEach(
        hortifruti -> {
          final var hortifrutiResponse =
              new HortifrutiResponseModel(
                  hortifruti.getId(),
                  hortifruti.getName(),
                  hortifruti.getDescription(),
                  hortifruti.getPrice(),
                  hortifruti.getCategory(),
                  hortifruti.getImage());
          responseHortifruti.add(hortifrutiResponse);
        });
    return presenter.prepareSuccessView(responseHortifruti);
  }
}
