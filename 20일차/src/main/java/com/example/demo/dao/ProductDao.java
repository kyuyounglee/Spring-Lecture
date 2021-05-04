package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductDao {
	public List<Product> productList() throws Exception;
	public Product productbyId(String id) throws Exception;
	
}
