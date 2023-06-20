package com.felipeguimaraes42.archbookstore.mvc.controller.services;

import static java.util.Objects.isNull;

import com.felipeguimaraes42.archbookstore.mvc.controller.entities.BookEntity;
import com.felipeguimaraes42.archbookstore.mvc.controller.entities.CartItemEntity;
import com.felipeguimaraes42.archbookstore.mvc.controller.entities.CustomerEntity;
import com.felipeguimaraes42.archbookstore.mvc.controller.entities.ShoppingCartEntity;
import com.felipeguimaraes42.archbookstore.mvc.controller.repositories.BookRepository;
import com.felipeguimaraes42.archbookstore.mvc.controller.repositories.CartItemRepository;
import com.felipeguimaraes42.archbookstore.mvc.controller.repositories.CartRepository;
import com.felipeguimaraes42.archbookstore.mvc.controller.repositories.CustomerRepository;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AddCartService {
  private final CartRepository cartRepository;
  private final CartItemRepository cartItemRepository;
  private final CustomerRepository customerRepository;
  private final BookRepository bookRepository;

  public AddCartService(
      final CartRepository cartRepository,
      final CartItemRepository cartItemRepository,
      final CustomerRepository customerRepository,
      final BookRepository bookRepository) {
    this.cartRepository = cartRepository;
    this.cartItemRepository = cartItemRepository;
    this.customerRepository = customerRepository;
    this.bookRepository = bookRepository;
  }

  public void execute(final String username, final Long itemId) {
    final CustomerEntity customer = customerRepository.findByUsername(username).get();
    BookEntity item = bookRepository.findById(itemId).get();
    ShoppingCartEntity cart = customer.getCart();
    if (isNull(cart)) {
      ShoppingCartEntity newCart = new ShoppingCartEntity();
      newCart.setCustomer(customer);
      cart = cartRepository.save(newCart);
    }

    Set<CartItemEntity> cartItemList = cart.getCartItems();
    for (CartItemEntity cartItem : cartItemList) {
      if (cartItem.getBook().getId().equals(item.getId())) {
        cartItem.setQuantity(cartItem.getQuantity() + 1);
        cartRepository.save(cart);
        return;
      }
    }

    CartItemEntity newCartItem = new CartItemEntity();
    newCartItem.setCart(cart);
    newCartItem.setBook(item);
    newCartItem.setQuantity(1);
    CartItemEntity savedItem = cartItemRepository.save(newCartItem);

    cart.getCartItems().add(savedItem);
    cartRepository.save(cart);
  }
}
