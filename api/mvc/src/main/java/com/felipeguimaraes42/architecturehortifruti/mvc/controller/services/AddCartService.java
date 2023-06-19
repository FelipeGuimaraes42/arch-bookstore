package com.felipeguimaraes42.architecturehortifruti.mvc.controller.services;

import static java.util.Objects.isNull;

import com.felipeguimaraes42.architecturehortifruti.mvc.controller.entities.CartItemEntity;
import com.felipeguimaraes42.architecturehortifruti.mvc.controller.entities.CustomerEntity;
import com.felipeguimaraes42.architecturehortifruti.mvc.controller.entities.HortifrutiEntity;
import com.felipeguimaraes42.architecturehortifruti.mvc.controller.entities.ShoppingCartEntity;
import com.felipeguimaraes42.architecturehortifruti.mvc.controller.repositories.CartItemRepository;
import com.felipeguimaraes42.architecturehortifruti.mvc.controller.repositories.CartRepository;
import com.felipeguimaraes42.architecturehortifruti.mvc.controller.repositories.CustomerRepository;
import com.felipeguimaraes42.architecturehortifruti.mvc.controller.repositories.HortifrutiRepository;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AddCartService {
  private final CartRepository cartRepository;
  private final CartItemRepository cartItemRepository;
  private final CustomerRepository customerRepository;
  private final HortifrutiRepository hortifrutiRepository;

  public AddCartService(
      final CartRepository cartRepository,
      final CartItemRepository cartItemRepository,
      final CustomerRepository customerRepository,
      final HortifrutiRepository hortifrutiRepository) {
    this.cartRepository = cartRepository;
    this.cartItemRepository = cartItemRepository;
    this.customerRepository = customerRepository;
    this.hortifrutiRepository = hortifrutiRepository;
  }

  public void execute(final String username, final Long itemId) {
    final CustomerEntity customer = customerRepository.findByUsername(username).get();
    HortifrutiEntity item = hortifrutiRepository.findById(itemId).get();
    ShoppingCartEntity cart = customer.getCart();
    if (isNull(cart)) {
      ShoppingCartEntity newCart = new ShoppingCartEntity();
      newCart.setCustomer(customer);
      cart = cartRepository.save(newCart);
    }

    Set<CartItemEntity> cartItemList = cart.getCartItems();
    for (CartItemEntity cartItem : cartItemList) {
      if (cartItem.getHortifruti().getId().equals(item.getId())) {
        cartItem.setQuantity(cartItem.getQuantity() + 1);
        cartRepository.save(cart);
        return;
      }
    }

    CartItemEntity newCartItem = new CartItemEntity();
    newCartItem.setCart(cart);
    newCartItem.setHortifruti(item);
    newCartItem.setQuantity(1);
    CartItemEntity savedItem = cartItemRepository.save(newCartItem);

    cart.getCartItems().add(savedItem);
    cartRepository.save(cart);
  }
}
