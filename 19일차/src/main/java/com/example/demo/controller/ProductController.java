package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

public class ProductController {
	@Autowired
	ProductService service;
	
	@RequestMapping("list")
	public String productList(Model model) throws Exception{
		List<Product> productList = service.productList();
		model.addAttribute("productList", productList);
		return "list";
	}
	
}
