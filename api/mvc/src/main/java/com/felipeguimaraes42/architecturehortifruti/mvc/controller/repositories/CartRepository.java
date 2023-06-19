package com.felipeguimaraes42.architecturehortifruti.mvc.controller.repositories;

import com.felipeguimaraes42.architecturehortifruti.mvc.controller.entities.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<ShoppingCartEntity, Long> {}
