package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import model.Product;
import model.ProductDAO;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO dao;
	
	@RequestMapping("/productDetail")
	public String productDetail(
			@RequestParam(value = "id",required = false) String id,
			Model model
			) {		
		// 리스트로부터 온 상품의 id를 가지고 상품정보를 jsp로 보낸다
		Product product =  dao.selectById(id);
		model.addAttribute("product",product);
		return "productDetail";
	}
	
	@RequestMapping("/productList")
	public String productList(
			Model model
			) {		
		List<Product> productlist =  dao.selectByAll();
		System.out.println("productlist.size() = "+productlist.size());
		model.addAttribute("productlist",productlist);		
		return "productList";
	}
	
	
//	@PostMapping
//	public String insertProduct() {
//		// 입력을위한 데이터를 받고 insert 한다음 다시 리스트로 복귀 
//		return "productList";
//	}
}
