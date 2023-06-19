package com.felipeguimaraes42.architecturehortifruti.mvc.controller.mappers;

import com.felipeguimaraes42.architecturehortifruti.mvc.controller.entities.CartItemEntity;
import com.felipeguimaraes42.architecturehortifruti.mvc.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartItemMapper {
  CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

  CartItem toCartItem(final CartItemEntity cartItemEntity);

  CartItemEntity toCartItemEntity(final CartItem cartItem);
}
