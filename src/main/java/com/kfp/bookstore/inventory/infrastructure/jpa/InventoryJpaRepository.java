package com.kfp.bookstore.inventory.infrastructure.jpa;

import com.kfp.bookstore.inventory.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryJpaRepository extends JpaRepository<Inventory, Integer> {

}
