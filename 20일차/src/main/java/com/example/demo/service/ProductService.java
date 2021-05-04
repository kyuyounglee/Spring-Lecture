package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;
public interface ProductService {
	public List<Product> productList() throws Exception;
	public Product productbyId(String id) throws Exception;
}
