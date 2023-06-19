package com.felipeguimaraes42.archbookstore.bbom.services;

import com.felipeguimaraes42.archbookstore.bbom.domains.Hortifruti;
import com.felipeguimaraes42.archbookstore.bbom.repositories.HortifrutiRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GetHortifrutiService {

  private final HortifrutiRepository hortifrutiRepository;

  public GetHortifrutiService(final HortifrutiRepository hortifrutiRepository) {
    this.hortifrutiRepository = hortifrutiRepository;
  }

  public List<Hortifruti> getAll() {
    return hortifrutiRepository.findAll();
  }

  public Hortifruti getOne(final Long id) {
    Optional<Hortifruti> hortifrutiOptional = hortifrutiRepository.findById(id);
    return hortifrutiOptional.orElse(null);
  }

  public List<Hortifruti> searchByName(final String query) {
    return hortifrutiRepository.findByName(query.toUpperCase());
  }
}
