package com.kfp.bookstore.inventory.application;

import com.kfp.bookstore.inventory.domain.Inventory;
import com.kfp.bookstore.inventory.domain.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ObtainInventory {

    InventoryRepository inventoryRepository;

    public List<Inventory> execute(){
        return this.inventoryRepository.findAll();
    }
}
