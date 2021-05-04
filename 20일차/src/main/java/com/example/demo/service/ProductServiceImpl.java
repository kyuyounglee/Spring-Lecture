package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;
	
	@Override
	public List<Product> productList() throws Exception {
		return dao.productList();
	}

	@Override
	public Product productbyId(String id) throws Exception {
		return dao.productbyId(id);
	}

}
