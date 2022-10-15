package com.vertex.demo.vettex_demo;

import java.util.ArrayList;
import java.util.List;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * Hello world!
 *
 */
public class EmployeeResource {
	public static void main(String[] args) {

		System.out.println("Hello");

		List<Employee> emp = new ArrayList<Employee>();

		Vertx vert = Vertx.vertx();
		HttpServer server = vert.createHttpServer();

		Router router = Router.router(vert);

		Route postHandler = router.post("/addEmployee").handler(BodyHandler.create()).handler(routingContext -> {

			final Employee employee = Json.decodeValue(routingContext.getBody(), Employee.class);
			HttpServerResponse response = routingContext.response();
			response.setChunked(true);
			emp.add(employee);
			response.end(emp.size() + "Employees added succesfully...");
		});

		Route getHandler = router.get("/getEmployee").produces("*/json").handler(routingContext -> {
			routingContext.response().setChunked(true).end(Json.encodePrettily(emp));
		});

		Route getHandlerByName = router.get("/getEmployee/:name").produces("*/json").handler(routingContext -> {

			String name = routingContext.request().getParam("name");

			routingContext.response().setChunked(true)
					.end(Json.encodePrettily(emp.stream().filter(e -> e.getName().equals(name)).findFirst().get()));

		});

		server.requestHandler(router::accept).listen(8001);

	}
}
