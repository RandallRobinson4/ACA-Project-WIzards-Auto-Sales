package com.aca.project.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aca.project.model.Car;
import com.aca.project.model.Make;
import com.aca.project.model.Model;
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
	@Path("/id/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public Car getCarById(@PathParam("value") int id) {
		return carService.getCarById(id);
	}
	
	@GET
	@Path("/make/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getByMakeName(@PathParam("value") String makeName) {
		return carService.getByMakeName(makeName);
	}

	@GET
	@Path("/model/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getByModel(@PathParam("value") String modelName) {
		return carService.getByModelName(modelName);
	}
	
	@GET
	@Path("/models")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Model> getModels() {
		return carService.getModels();
	}
	
	@GET
	@Path("/makes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Make> getMakes() {
		return carService.getMakes();
	}
	
	@DELETE
	@Path("/id/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public Car deleteMovieById(@PathParam("value") int id) {
		Car car = carService.deleteCarById(id);
		return car;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Car addCar(Car newCar) {
		Car car = carService.addCar(newCar);
		return car;
	}
	
	@POST
	@Path("/make/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public Make addMake(@PathParam("value")String newMake) {
		Make make = carService.addMake(newMake);
		return make;
	}
	
	@POST
	@Path("/model/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public Model addModel(@PathParam("value") String newModel, Make make) {
		Model model = carService.addModel(newModel, make);
		return model;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Car updateCar(Car updatedCar) {
		Car car = carService.updateCar(updatedCar);
		return car;
	}
}
