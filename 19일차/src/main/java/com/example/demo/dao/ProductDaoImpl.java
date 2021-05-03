package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.model.Product;

public class ProductDaoImpl implements ProductDao {
	SqlSession sqlSession;
	
	public static String nameSpace = "com.example.demo.dao.ProductDao";
	
	@Override
	public List<Product> productList() throws Exception {
		return sqlSession.selectList(nameSpace+".productList");
	}

}
