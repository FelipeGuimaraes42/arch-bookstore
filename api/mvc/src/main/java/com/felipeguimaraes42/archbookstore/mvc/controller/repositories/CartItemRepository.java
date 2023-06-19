package com.felipeguimaraes42.archbookstore.mvc.controller.repositories;

import com.felipeguimaraes42.archbookstore.mvc.controller.entities.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {}
