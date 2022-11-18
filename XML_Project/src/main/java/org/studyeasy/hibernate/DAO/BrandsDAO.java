package org.studyeasy.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.showroom.entities.BrandEntity;

public class BrandsDAO {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(BrandEntity.class)
			.buildSessionFactory();
	Session session = factory.getCurrentSession();

	public List<BrandEntity> getBrands() {
		session.beginTransaction();
		List<BrandEntity> brandsList = session.createQuery("from brands").getResultList();
		return brandsList;
	}

	public void addBrand(BrandEntity brand) {
		session.beginTransaction();
		session.save(brand);
		session.getTransaction().commit();
		System.out.println("Row Added!");
	}

	public void updateBrand(BrandEntity updatedBrand) {
		session.beginTransaction();
		int brandId = updatedBrand.getBrandId();
		BrandEntity brand = session.get(BrandEntity.class, brandId);
		brand.setBrandId(updatedBrand.getBrandId());
		brand.setBrandName(updatedBrand.getBrandName());
		session.getTransaction().commit();
		System.out.println("Row Updated!");
	}

	public void deleteBrand(int brandId) {
		session.beginTransaction();
		BrandEntity brand = session.get(BrandEntity.class, brandId);
		session.delete(brand);
		session.getTransaction().commit();
		System.out.println("Row Deleted!");
	}

}
