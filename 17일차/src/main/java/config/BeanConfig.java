package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.ProductController;
import model.ProductDAO;

@Configuration
public class BeanConfig {

	@Bean
	public ProductDAO productDao() {
		return new ProductDAO();
	}
	
	@Bean
	public ProductController productController() {
		return new ProductController();
	}
}
