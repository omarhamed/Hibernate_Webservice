package org.studyeasy.showroom.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.studyeasy.showroom.model.Brand;
import org.studyeasy.showroom.services.BrandsService;

@Path("showroom/brands")
public class BrandsResource {

	BrandsService brandService = new BrandsService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Brand> getBrands() {
		List<Brand> list = brandService.getBrands();
		return list;
	}
	
	@GET
	@Path("/{brandId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Brand getBrand(@PathParam("brandId") int brandId) {
		Brand brand = brandService.getBrand(brandId);
		return brand;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postBrands(Brand brand, @Context UriInfo uriInfo) {
		URI locaUri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(brand.getBrandId())).build();
		brandService.addBrand(brand);
		return Response.created(locaUri).entity(brand).build();
//				status(Status.CREATED).entity(brand).build();
	}

	@PUT
	@Path("/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateBrand(@PathParam("brandId") int brandId, Brand updatedBrand) {
		updatedBrand.setBrandId(brandId);
		brandService.updateBrand(updatedBrand);
	}

	@DELETE
	@Path("/{brandId}")
	public void deleteBrand(@PathParam("brandId") int brandId) {
		brandService.deleteBrand(brandId);
	}

	@Path("/{brandId}/products")
	public ProductsResource productsDelegation() {
		return new ProductsResource();
	}

}
