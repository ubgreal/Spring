package com.example.sesiones._5_6.repository;

import com.example.sesiones._5_6.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository <Laptop,Long> {
}
