package com.example.sesiones._5_6;

import com.example.sesiones._5_6.entities.Laptop;
import com.example.sesiones._5_6.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Sesiones456Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Sesiones456Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		// CRUD

		// Crearte Laptop
		Laptop laptop1 = new Laptop(null,"DELL","SKL5625", LocalDate.of(2018,5,8),50,300);
		Laptop laptop2 = new Laptop(null,"DELL","SKL5555", LocalDate.of(2016,10,20),80,500);
		Laptop laptop3 = new Laptop(null,"DELL","SKL5555", LocalDate.of(2016,10,20),100,100);


		// Storage a Laptop
		System.out.println("Numbers of Laptops in DataBase: " + repository.findAll().size());

		repository.save(laptop1);
		repository.save(laptop2);
		repository.save(laptop3);



		// Delete a Laptop
		// repository.deleteById(1L);
		System.out.println("Numbers of Laptops in DataBase: " + repository.findAll().size());

	}
}
