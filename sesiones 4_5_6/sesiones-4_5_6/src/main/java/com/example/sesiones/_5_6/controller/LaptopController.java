package com.example.sesiones._5_6.controller;

import com.example.sesiones._5_6.entities.Laptop;
import com.example.sesiones._5_6.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    // Atributos

    private LaptopRepository laptopRepository;

    // Constructor

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    // CRUD about entiti laptop.

    // Find all laptops.
@GetMapping("/api/laptops")
    public List<Laptop>findAll() {
        // Resque and return the laptops in database.
        return laptopRepository.findAll();
    }

    // Find for a new laptop.
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity <Laptop> findOneById(@PathVariable Long id) {

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        // Opcion 1

        if(laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();

        // Opcion 2
        // return laptopOpt.orElse(null);
        // return laptopOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    // Create a new laptop in database.
    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop) {
        // Save the laptops got from parameter in database.
        return laptopRepository.save(laptop);
    }


    // Update a new laptop in database.

    // Erase a new laptop in database.

}
