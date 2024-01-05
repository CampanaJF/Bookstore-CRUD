package com.kfp.bookstore.inventory.application;

import com.kfp.bookstore.inventory.domain.Inventory;
import com.kfp.bookstore.inventory.domain.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateInventory {

    private final InventoryRepository inventoryRepository;

    public void execute(Inventory inventory){
        inventoryRepository.save(inventory);
    }
}
