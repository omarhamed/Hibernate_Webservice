package org.studyeasy.showroom.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.studyeasy.showroom.model.Product;
import org.studyeasy.showroom.services.ProductService;

public class ProductsResource {

	ProductService productService = new ProductService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductsByBrand(@PathParam("brandId") int brandId,
			@QueryParam("category") String category,@QueryParam("start") int start,
			@QueryParam("end") int end) {
		List<Product> ProductList;
		if (category != null) {
			ProductList = productService.getProductsByBrandAndCategory(brandId,category);
		} else {
			ProductList = productService.getProductsByBrand(brandId);
		}
		if (end > 0) {
			ProductList = ProductList.subList(start, end);
		}
		return ProductList;
	}
}
