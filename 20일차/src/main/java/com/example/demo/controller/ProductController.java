package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	@RequestMapping(value = "list")
	public String productList(Model model) throws Exception{		
		List<Product> productList = service.productList();
		model.addAttribute("productList", productList);
		return "list";
	}
	
	@GetMapping(value = "list/{id}")	
	public String productbyId(
			Model model,
			@PathVariable String id
			) throws Exception 
	{		
		Product product = service.productbyId(id);
		model.addAttribute("product",product);
		return "listDetail";
	}
	
	
	
}
