package com.product.tech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.product.tech.dao.ProductRepository;
import com.product.tech.dto.ProductDTO;
import com.product.tech.entity.Product;

import jakarta.persistence.EntityNotFoundException;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product updateProduct(ProductDTO productDto) {
		Product existingProduct = productRepository.findById(productDto.getId())
				.orElseThrow(() -> new RuntimeException("Product not Found"));
		existingProduct.setName(productDto.getName());
		existingProduct.setDescription(productDto.getDescription());
		existingProduct.setPrice(productDto.getPrice());

		return productRepository.save(existingProduct);
	}

	@Override
	public String createProduct(ProductDTO productDto) {
		try {
			Product product = new Product();
			product.setName(productDto.getName());
			product.setDescription(productDto.getDescription());
			product.setPrice(productDto.getPrice());
			productRepository.save(product);
			return "Product Saved SuccessFully";
		} catch (Exception e) {
			return "Failed to create Product" + e.getMessage();
		}
	}

	@Override
	public String deleteProduct(Long id) {
		Optional<Product> existingProduct = productRepository.findById(id);
		if (existingProduct != null) {
			productRepository.deleteById(id);
			return "Product Delated SeccessFully";
		}
		return "Product Not Found";
	}

	@Override
	public Product getProductById(Long id) {
		Optional<Product> existingProduct = productRepository.findById(id);
		if (existingProduct.isPresent()) {
			return existingProduct.get();
		} else {
			throw new EntityNotFoundException("Product with ID " + id + " not found");
		}
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

}
