package org.studyeasy.showroom.services;

import java.util.List;

import org.studyeasy.hibernate.DAO.BrandsDAOImpl;
import org.studyeasy.showroom.model.Brand;

public class BrandsService {

	BrandsDAOImpl DAO = new BrandsDAOImpl();

	public List<Brand> getBrands() {
		List<Brand> list = DAO.getBrands();
		return list;
	}

	public Brand getBrand(int brandId) {
		Brand brandEntity = DAO.getBrand(brandId);
		return brandEntity;
	}

	public void addBrand(Brand brand) {
		DAO.addBrand(brand);

	}

	public void updateBrand(Brand updatedBrand) {
		DAO.updateBrand(updatedBrand);

	}

	public void deleteBrand(int brandId) {
		DAO.deleteBrand(brandId);

	}

}
