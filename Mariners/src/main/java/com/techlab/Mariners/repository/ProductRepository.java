package com.techlab.Mariners.repository;

import com.techlab.Mariners.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNombreContainingIgnoreCase(String nombre);

    List<Product> findByCategoriaContainingIgnoreCase(String categoria);

    List<Product> findByNombreContainingIgnoreCaseAndCategoriaContainingIgnoreCase(String nombre, String categoria);
}
