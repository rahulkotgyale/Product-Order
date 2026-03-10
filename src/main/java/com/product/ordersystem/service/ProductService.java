package com.product.ordersystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.ordersystem.dto.ProductDTO;

@Service
public interface ProductService {

	ProductDTO addProduct(ProductDTO productDTO);

	ProductDTO getProductById(Long id);

	List<ProductDTO> getAllProducts();

	ProductDTO updateProduct(Long id, ProductDTO productDTO);

	void deleteProduct(Long id);

}
