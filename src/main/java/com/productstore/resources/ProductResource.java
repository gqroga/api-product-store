package com.productstore.resources;

import com.productstore.entities.Product;
import com.productstore.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@Tag(name = "Products", description = "Operations related to Product management")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    @Tag(name = "Find All Products", description = "Retrieve all products from the database")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    @Tag(name = "Find Product by ID", description = "Retrieve a specific product by their ID")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product obj = productService.findById(id);
        return ResponseEntity.ok(obj);
    }
}
