package com.felipeguimaraes42.architecturehortifruti.mvc.controller.mappers;

import com.felipeguimaraes42.architecturehortifruti.mvc.controller.dtos.ShoppingCartDTO;
import com.felipeguimaraes42.architecturehortifruti.mvc.controller.entities.ShoppingCartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {
  CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

  ShoppingCartDTO toCartDTO(final ShoppingCartEntity cartEntity);
}
