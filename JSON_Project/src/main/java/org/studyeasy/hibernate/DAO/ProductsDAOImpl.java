package org.studyeasy.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.showroom.model.Brand;
import org.studyeasy.showroom.model.Product;

public class ProductsDAOImpl implements ProductsDAO {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
			.addAnnotatedClass(Brand.class).buildSessionFactory();
	Session session = factory.getCurrentSession();

	public List<Product> getProductsByBrand(int brandId) {
		session.beginTransaction();
		List<Product> productList;
		String HQL = "from products where brandId = '" + brandId + "'";
		productList = session.createQuery(HQL).getResultList();
		return productList;
	}

	public List<Product> getProductsByBrandAndCategory(int brandId, String category) {
		session.beginTransaction();
		List<Product> productList;
		String HQL = "from products where brandId = '" + brandId + "' And category = '" + category + "'";
		productList = session.createQuery(HQL).getResultList();
		return productList;
	}
}
