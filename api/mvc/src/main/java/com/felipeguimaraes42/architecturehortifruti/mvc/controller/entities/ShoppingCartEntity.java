package com.felipeguimaraes42.architecturehortifruti.mvc.controller.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "cart")
public class ShoppingCartEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "customer_id", referencedColumnName = "id")
  private CustomerEntity customer;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cart")
  private Set<CartItemEntity> cartItems;

  public ShoppingCartEntity() {
    this.cartItems = new HashSet<>();
  }
}
