package com.example.sesiones._5_6.service;


import com.example.sesiones._5_6.entities.Laptop;

public class LaptopPriceCalculator {

    public double calculatePrice(Laptop laptop){
        double price = laptop.getPrice();

        if(laptop.getPages()> 500){
            price += 5;
        }
        // envio
        price += 2.99;
        return price;
    }
}
