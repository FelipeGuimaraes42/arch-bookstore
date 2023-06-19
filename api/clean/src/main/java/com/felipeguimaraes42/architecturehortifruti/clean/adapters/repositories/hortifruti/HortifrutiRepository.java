package com.felipeguimaraes42.architecturehortifruti.clean.adapters.repositories.hortifruti;

import com.felipeguimaraes42.architecturehortifruti.clean.adapters.mappers.HortifrutiDataMapper;
import com.felipeguimaraes42.architecturehortifruti.clean.usecases.gateways.HortifrutiGateway;
import java.util.List;

public class HortifrutiRepository implements HortifrutiGateway {
  private final JpaHortifrutiRepository repository;

  public HortifrutiRepository(final JpaHortifrutiRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<HortifrutiDataMapper> findAll() {
    return repository.findAll();
  }
}
