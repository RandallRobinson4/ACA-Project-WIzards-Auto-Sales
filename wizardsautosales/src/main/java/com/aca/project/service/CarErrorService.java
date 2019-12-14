package com.aca.project.service;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.aca.project.model.CarError;


public class CarErrorService {

		private static CarError error = new CarError();
		
		public static void cannotDeleteMake() {
			error.setId(11);
			error.setErrorMessage("Cannot delete a make that belongs to a car in our inventory. Remove the car from the inventory first.");
			throwError(error);
		}
		
		private static void throwError(CarError error) {
			Response response = Response.status(400)
					.entity(error)
					.build();
				throw new WebApplicationException(response);
		}
}
