package org.studyeasy.hibernate.DAO;

import java.util.List;

import org.studyeasy.showroom.model.Brand;

public interface BrandsDAO {
	public List<Brand> getBrands();
	public Brand getBrand(int brandId);
	public void addBrand(Brand brand);
	public void updateBrand(Brand updatedBrand);
	public void deleteBrand(int brandId);
}
