package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	@RequestMapping(value = "list")
	public String productList(Model model) throws Exception{
		System.out.println("#########################");
		List<Product> productList = service.productList();
		model.addAttribute("productList", productList);
		
		for (Product product : productList) {
			System.out.println(product.getP_id());
		}
		
		return "list";
	}
	
}
