package com.techlab.Mariners.service;

import com.techlab.Mariners.entity.Product;
import com.techlab.Mariners.repository.ProductRepository;
import com.techlab.Mariners.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.techlab.Mariners.utils.StringUtils.validation;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final StringUtils stringUtils;

    public ProductService(ProductRepository productRepository, StringUtils stringUtils) {
        this.productRepository = productRepository;
        this.stringUtils = stringUtils;
    }

    public Product createProduct(Product product){
        System.out.println("Producto ingresado: " + product);

        Product productSavedWithId = this.productRepository.save(product);

        return productSavedWithId;
    }

    public Product getProductById(Long id){
        Optional<Product> productOptional = this.productRepository.findById(id);

        if (productOptional.isEmpty()){
            throw new RuntimeException("Producto no encontrado con Id: " + id);
        }

        return productOptional.get();
    }

    public List<Product> findAllProducts(String nombre, String categoria){
        if (!nombre.isEmpty() && !categoria.isEmpty()){
            return this.productRepository.findByNombreContainingIgnoreCaseAndCategoriaContainingIgnoreCase(nombre, categoria);
        }

        if (!nombre.isEmpty()){
            return this.productRepository.findByNombreContainingIgnoreCase(nombre);
        }

        if (!categoria.isEmpty()){
            return this.productRepository.findByCategoriaContainingIgnoreCase(categoria);
        }
        return this.productRepository.findAll();
    }

    public Product editProductById(Long id, Product dataToEdit){
        Product product = this.getProductById(id);

        if (!stringUtils.isEmpty(dataToEdit.getNombre())){
            System.out.printf("Editando el nombre del producto: anterior:%s - nuevo:%s", product.getNombre(), dataToEdit.getNombre());

            product.setNombre(dataToEdit.getNombre());
        }

        return this.productRepository.save(product);
    }

    public Product deleteProductById(Long id){
        Product product = this.getProductById(id);

        this.productRepository.delete(product);

        return product;
    }
}
