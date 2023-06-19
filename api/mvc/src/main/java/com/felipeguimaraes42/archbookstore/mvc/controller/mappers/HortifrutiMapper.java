package com.felipeguimaraes42.archbookstore.mvc.controller.mappers;

import com.felipeguimaraes42.archbookstore.mvc.controller.dtos.HortifrutiDTO;
import com.felipeguimaraes42.archbookstore.mvc.controller.entities.HortifrutiEntity;
import com.felipeguimaraes42.archbookstore.mvc.model.Hortifruti;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HortifrutiMapper {
  HortifrutiMapper INSTANCE = Mappers.getMapper(HortifrutiMapper.class);

  HortifrutiDTO toHortifrutiDTO(final HortifrutiEntity hortifrutiEntity);

  List<HortifrutiDTO> toHortifrutiDTO(final List<HortifrutiEntity> hortifrutiEntities);

  HortifrutiEntity toHortifrutiEntity(final Hortifruti hortifruti);
}
