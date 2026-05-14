package com.dig.inventory.diginventory.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController extends AbstractInventoryController {

    @GetMapping("/test")
    String test () {
        return "Helo World";
    }
}