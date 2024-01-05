package com.kfp.bookstore.inventory.infrastructure;

import com.kfp.bookstore.inventory.domain.Inventory;
import com.kfp.bookstore.inventory.domain.InventoryRepository;
import com.kfp.bookstore.inventory.infrastructure.jpa.InventoryJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class InventoryRepositoryImpl implements InventoryRepository {

    private final InventoryJpaRepository inventoryJpaRepository;
    @Override
    public void save(Inventory inventory) {
        inventoryJpaRepository.save(inventory);
    }
}
