package com.product.tech.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.product.tech.dto.ProductDTO;
import com.product.tech.entity.Product;
import com.product.tech.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PutMapping("/update")
	public Product updateProduct(@RequestBody ProductDTO productDto) {
		return productService.updateProduct(productDto);
		
	}

	@PostMapping("/create")
	public String createProduct(@RequestBody ProductDTO productDto) {
		return productService.createProduct(productDto);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		return productService.deleteProduct(id);
	}

	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	@GetMapping("/all")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

}
