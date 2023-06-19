package com.felipeguimaraes42.architecturehortifruti.mvc.controller.repositories;

import com.felipeguimaraes42.architecturehortifruti.mvc.controller.entities.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {}
