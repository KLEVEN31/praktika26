package com.example.praktik26.controller;

import com.example.praktik26.dto.CustomerDto;
import com.example.praktik26.dto.LotDto;
import com.example.praktik26.service.PurchaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Для React Frontend
public class PurchaseController {

    private final PurchaseService service;

    // Конструктор вместо Lombok
    public PurchaseController(PurchaseService service) {
        this.service = service;
    }

    // --- Customers ---

    @GetMapping("/customers")
    public List<CustomerDto> getCustomers() {
        return service.getAllCustomers();
    }

    @PostMapping("/customers")
    public void createCustomer(@RequestBody CustomerDto customer) {
        service.createCustomer(customer);
    }

    @PutMapping("/customers/{code}")
    public void updateCustomer(@PathVariable("code") String code, @RequestBody CustomerDto customer) {
        service.updateCustomer(code, customer);
    }

    // --- Lots ---

    @GetMapping("/lots")
    public List<LotDto> getLots() {
        return service.getAllLots();
    }

    @PostMapping("/lots")
    public void createLot(@RequestBody LotDto lot) {
        service.createLot(lot);
    }
}