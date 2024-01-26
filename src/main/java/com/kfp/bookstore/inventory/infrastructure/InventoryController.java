package com.kfp.bookstore.inventory.infrastructure;

import com.kfp.bookstore.inventory.application.ObtainInventory;
import com.kfp.bookstore.inventory.domain.Inventory;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/inventory")
public class InventoryController {

    private final ObtainInventory obtainInventory;

    @Hidden
    @GetMapping
    ResponseEntity<List<Inventory>> list(){

        return new ResponseEntity<>(obtainInventory.execute(), HttpStatus.OK);
    }

}
