package com.product.tech.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.product.tech.dto.ProductDTO;
import com.product.tech.entity.Product;

@Service
public interface ProductService {
	public Product updateProduct(ProductDTO productDto);
	public String createProduct(ProductDTO productDto);
	public String deleteProduct(Long id);
	public Product getProductById(Long id);
	public List<Product> getAllProducts();

}
