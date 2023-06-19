package com.felipeguimaraes42.archbookstore.mvc.controller.services;

import com.felipeguimaraes42.archbookstore.mvc.controller.entities.CartItemEntity;
import com.felipeguimaraes42.archbookstore.mvc.controller.entities.CustomerEntity;
import com.felipeguimaraes42.archbookstore.mvc.controller.entities.ShoppingCartEntity;
import com.felipeguimaraes42.archbookstore.mvc.controller.repositories.CartItemRepository;
import com.felipeguimaraes42.archbookstore.mvc.controller.repositories.CartRepository;
import com.felipeguimaraes42.archbookstore.mvc.controller.repositories.CustomerRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateCartService {
  private final CartRepository cartRepository;
  private final CartItemRepository itemRepository;
  private final CustomerRepository customerRepository;

  public UpdateCartService(
      final CartRepository cartRepository,
      final CartItemRepository itemRepository,
      final CustomerRepository customerRepository) {
    this.cartRepository = cartRepository;
    this.itemRepository = itemRepository;
    this.customerRepository = customerRepository;
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void execute(final String username, final Long itemId, final Integer newQuantity) {
    final CustomerEntity customer = customerRepository.findByUsername(username).get();
    ShoppingCartEntity cart = cartRepository.findById(customer.getCart().getId()).get();
    if (newQuantity > 0) {
      cart.getCartItems()
          .forEach(
              cartItem -> {
                if (cartItem.getHortifruti().getId().equals(itemId)) {
                  cartItem.setQuantity(newQuantity);
                }
              });
    } else {
      Set<CartItemEntity> newCartItems = new HashSet<>();
      for (CartItemEntity cartItem : cart.getCartItems()) {
        if (cartItem.getHortifruti().getId().equals(itemId)) {
          itemRepository.delete(cartItem);
        } else {
          newCartItems.add(cartItem);
        }
      }
      cart.setCartItems(newCartItems);
    }

    cartRepository.save(cart);
  }
}
