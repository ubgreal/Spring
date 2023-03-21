package com.example.sesiones._5_6.service;

import com.example.sesiones._5_6.entities.Laptop;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LaptopPriceCalculatorTest {

    @Test
    void calculatePrice() {

        // Test configuration.
        Laptop laptop = new Laptop(1L, "ACER","JKdue", LocalDate.now(),100,500);
        LaptopPriceCalculator calculator = new LaptopPriceCalculator();

        // The behavior to be tested is executed.
        double price = calculator.calculatePrice(laptop);
        System.out.println(laptop);
        // Assertions test
        assertTrue(price>0);
    }
}