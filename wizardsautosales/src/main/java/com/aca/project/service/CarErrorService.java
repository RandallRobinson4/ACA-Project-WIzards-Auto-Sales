package com.aca.project.service;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.aca.project.model.CarError;


public class CarErrorService {

		private static CarError error = new CarError();
		
		public static void cannotDeleteMake() {
			error.setId(11);
			error.setErrorMessage("Cannot delete a make if there is a car or a model that references it. Please delete the associated car or model first.");
			throwError(error);
		}
		
		private static void throwError(CarError error) {
			Response response = Response.status(400)
					.entity(error)
					.build();
				throw new WebApplicationException(response);
		}

		public static void cannotDeleteModel() {
			error.setId(22);
			error.setErrorMessage("Cannot delete a model if there is a car that references it. Please delete the associated car first.");
			throwError(error);
		}
}
