package com.felipeguimaraes42.archbookstore.mvc.controller.services;

import com.felipeguimaraes42.archbookstore.mvc.controller.dtos.HortifrutiDTO;
import com.felipeguimaraes42.archbookstore.mvc.controller.entities.HortifrutiEntity;
import com.felipeguimaraes42.archbookstore.mvc.controller.mappers.HortifrutiMapper;
import com.felipeguimaraes42.archbookstore.mvc.controller.repositories.HortifrutiRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GetHortifrutiService {
  private final HortifrutiRepository hortifrutiRepository;

  public GetHortifrutiService(final HortifrutiRepository hortifrutiRepository) {
    this.hortifrutiRepository = hortifrutiRepository;
  }

  public List<HortifrutiDTO> getAll() {
    return HortifrutiMapper.INSTANCE.toHortifrutiDTO(hortifrutiRepository.findAll());
  }

  public HortifrutiEntity getOneById(final Long id) {
    Optional<HortifrutiEntity> hortifrutiOptional = hortifrutiRepository.findById(id);
    return hortifrutiOptional.orElse(null);
  }

  public List<HortifrutiEntity> searchByName(final String query) {
    return hortifrutiRepository.findByName(query.toUpperCase());
  }
}
