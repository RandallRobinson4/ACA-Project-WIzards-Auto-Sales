package com.aca.project.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aca.project.model.Car;
import com.aca.project.service.CarService;

@Path("inventory")
public class CarController {
	
	private CarService carService = new CarService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getallInventory() {
		return carService.getAllInventory();		
	}

	@GET
	@Path("/model/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getByModel(@PathParam("value") String modelName) {
		return carService.getByModelName(modelName);
	}
}
