package com.finproyectodam.relationaldb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase desde donde empieza el microservicio a funcionar
 * @author cristian && Joel
 * version 1.0
 */
@SpringBootApplication
public class RelationaldbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelationaldbApplication.class, args);
	}

	//TODO: vamos a eliminar canciones de playlist

}
