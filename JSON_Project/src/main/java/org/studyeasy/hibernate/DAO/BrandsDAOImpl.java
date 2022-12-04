package org.studyeasy.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.showroom.model.Brand;

public class BrandsDAOImpl implements BrandsDAO {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Brand.class)
			.buildSessionFactory();
	Session session = factory.getCurrentSession();
	
	@Override
	public List<Brand> getBrands() {
		session.beginTransaction();
		List<Brand> brandsList = session.createQuery("from brands").getResultList();
		return brandsList;
	}
	
	@Override
	public Brand getBrand(int brandId) {
		session.beginTransaction();
		Brand brand = session.get(Brand.class, brandId);
		return brand;
	}

	@Override
	public void addBrand(Brand brand) {
		session.beginTransaction();
		session.save(brand);
		session.getTransaction().commit();
		System.out.println("Row Added!");
	}

	@Override
	public void updateBrand(Brand updatedBrand) {
		session.beginTransaction();
		int brandId = updatedBrand.getBrandId();
		Brand brand = session.get(Brand.class, brandId);
		brand.setBrandId(updatedBrand.getBrandId());
		brand.setBrandName(updatedBrand.getBrandName());
		session.getTransaction().commit();
		System.out.println("Row Updated!");
	}

	@Override
	public void deleteBrand(int brandId) {
		session.beginTransaction();
		Brand brand = session.get(Brand.class, brandId);
		session.delete(brand);
		session.getTransaction().commit();
		System.out.println("Row Deleted!");
	}

	

	

}
