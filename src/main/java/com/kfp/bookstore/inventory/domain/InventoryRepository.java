package com.kfp.bookstore.inventory.domain;

import java.util.List;

public interface InventoryRepository {

    List<Inventory> findAll();
    void save(Inventory inventory);
}
