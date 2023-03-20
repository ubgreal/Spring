package com.example.sesiones._5_6.controller;

import com.example.sesiones._5_6.entities.Laptop;
import com.example.sesiones._5_6.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);


    // Attribute
    private LaptopRepository laptopRepository;

    // Constructor
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    // CRUD about entity laptop.

    /**
     * FIND all laptops that are present in dataBase (Laptops ArrayList)
     * http://localhost:8081/api/laptops
     *
     * @return
     */
    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        // Resque and return the laptops in database.
        return laptopRepository.findAll();
    }




    /**
     * Find for a new laptop according to Id.
     * http://localhost:8080/api/laptops/1
     * http://localhost:8080/api/laptops/2
     *
     * @param id
     * @return
     */
    @GetMapping("/api/laptops/{id}")
    @ApiOperation("Buscar un ordenador por clave primaria id Long")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        // Opción 1

        if (laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();

        // Opción 2
        // return laptopOpt.orElse(null);
        // return laptopOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }




    /**
     * CREATE a new laptop in database.
     * POST Method, It is not collide with finAll because are different HTTP: GET vs. POST Methods.
     *
     * @param laptop
     * @param headers
     * @return
     */
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        // Save the laptops got from parameter in database.
        if (laptop.getId() != null) {   // This means that id exits, so it does not a creation.
            log.warn("trying to create a book with id");
            System.out.println("trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }





    /**
     * UPDATE a new laptop that exits in database.
     * @param laptop
     * @return
     */
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        if (laptop.getId() == null) {
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())) {
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.notFound().build();
        }

        // Update procees.
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);  // The laptop returned has a primary key.
    }




    /**
     * DELETE a laptops that exits in database.
     */
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if (!laptopRepository.existsById(id)) {
            log.warn("Trying to delete a non existent laptop");
            return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    /*
     *DeleteAll laptops that exits in database.
     */
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request for delete all books");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}


