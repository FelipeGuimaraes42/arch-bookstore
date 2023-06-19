package com.felipeguimaraes42.archbookstore.mvc.controller.mappers;

import com.felipeguimaraes42.archbookstore.mvc.controller.entities.CartItemEntity;
import com.felipeguimaraes42.archbookstore.mvc.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartItemMapper {
  CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

  CartItem toCartItem(final CartItemEntity cartItemEntity);

  CartItemEntity toCartItemEntity(final CartItem cartItem);
}
