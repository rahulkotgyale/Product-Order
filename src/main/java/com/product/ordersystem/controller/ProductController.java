package com.product.ordersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.product.ordersystem.dto.ProductDTO;
import com.product.ordersystem.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // ADMIN - CREATE PRODUCT
    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO) {

        ProductDTO product = productService.addProduct(productDTO);
        return ResponseEntity.ok(product);
    }

    // USER - VIEW PRODUCT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {

        ProductDTO product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    // USER - VIEW ALL PRODUCTS
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {

        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // ADMIN - UPDATE PRODUCT
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id,
                                                    @Valid @RequestBody ProductDTO productDTO) {

        ProductDTO updatedProduct = productService.updateProduct(id, productDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    // ADMIN - DELETE PRODUCT
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

}