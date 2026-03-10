package com.product.ordersystem.serviceImpli;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.product.ordersystem.dto.ProductDTO;
import com.product.ordersystem.exception.ResourceNotFoundException;
import com.product.ordersystem.service.ProductService;

@Service
public class ProductServiceImpli implements ProductService {

    private List<ProductDTO> products = new ArrayList<>();

    // ADD PRODUCT
    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {

        productDTO.setId((long) (products.size() + 1));
        products.add(productDTO);

        return productDTO;
    }

    // GET PRODUCT BY ID
    @Override
    public ProductDTO getProductById(Long id) {

        for (ProductDTO product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }

        throw new ResourceNotFoundException("Product not found with id: " + id);
    }

    // GET ALL PRODUCTS
    @Override
    public List<ProductDTO> getAllProducts() {

        return products;
    }

    // UPDATE PRODUCT
    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {

        for (ProductDTO product : products) {

            if (product.getId().equals(id)) {

                product.setName(productDTO.getName());
                product.setDescription(productDTO.getDescription());
                product.setPrice(productDTO.getPrice());
                product.setQuantity(productDTO.getQuantity());
                product.setEnabled(productDTO.isEnabled());

                return product;
            }
        }

        throw new ResourceNotFoundException("Product not found with id: " + id);
    }

    // DELETE PRODUCT
    @Override
    public void deleteProduct(Long id) {

        boolean removed = products.removeIf(product -> product.getId().equals(id));

        if (!removed) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }

    }

}