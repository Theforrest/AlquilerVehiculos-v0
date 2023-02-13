package org.iesalandalus.programacion.alquilervehiculos;


import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class MainApp {

	public static void main(String[] args)  {
		// Ánimo!!!!
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo, vista);
		vista.setControlador(controlador);
		controlador.comenzar();
		controlador.terminar();
	}

}
