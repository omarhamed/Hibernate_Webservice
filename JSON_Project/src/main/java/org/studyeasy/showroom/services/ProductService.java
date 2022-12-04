package org.studyeasy.showroom.services;

import java.util.List;

import org.studyeasy.hibernate.DAO.ProductsDAOImpl;
import org.studyeasy.showroom.model.Product;

public class ProductService {

	ProductsDAOImpl DAO = new ProductsDAOImpl();
	
	public List<Product> getProductsByBrand(int brandId) {
		List<Product> ProductList = DAO.getProductsByBrand(brandId);
		return ProductList;
	}

	public List<Product> getProductsByBrandAndCategory(int brandId, String category) {
		List<Product> ProductList = DAO.getProductsByBrandAndCategory(brandId,category);
		return ProductList;
	}

}
