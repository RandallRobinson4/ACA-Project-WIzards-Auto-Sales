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


@Path("v1")
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
	public List<Car> getCarsByMakeName(@PathParam("value") String makeName) {
		return carService.getCarsByMakeName(makeName);
	}

	@GET
	@Path("/model/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getCarsByModelName(@PathParam("value") String modelName) {
		return carService.getCarsByModelName(modelName);
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
	
	@GET
	@Path("/email/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public void subscribeEmail(@PathParam("value") String email) {
		carService.subscribeEmail(email);
	}
	
	@GET
	@Path("/unusedmakes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Make> getUnusedMakes() {
		return carService.getUnusedMakes();
	}
	
	@GET
	@Path("/unusedmodels")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Model> getUnusedModels() {
		return carService.getUnusedModels();
	}
	
	@DELETE
	@Path("/id/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public Car deleteCarById(@PathParam("value") int id) {
		Car car = carService.deleteCarById(id);
		return car;
	}
	
	@DELETE
	@Path("/make/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public Make deleteMakeName(@PathParam("value") String makeName) {
		 carService.deleteMakeName(makeName);
		return new Make();
	}
	
	@DELETE
	@Path("/model/{value}")
	public Model deleteModelName(@PathParam("value") String modelName) {
		carService.deleteModelName(modelName);
		return new Model();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Car addCar(Car newCar) {
		Car car = carService.addCar(newCar);
		return car;
	}
	
	@POST
	@Path("/make")
	@Produces(MediaType.APPLICATION_JSON)
	public Make addMake(Make newMake) {
		Make make = carService.addMake(newMake);
		return make;
	}
	
	@POST
	@Path("/model")
	@Produces(MediaType.APPLICATION_JSON)
	public Model addModel(Model newModel) {
		Model model = carService.addModel(newModel);
		return model;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Car updateCar(Car updatedCar) {
		Car car = carService.updateCar(updatedCar);
		return car;
	}
}
