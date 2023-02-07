package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private static final String PATRON_FECHA = "((((([0-1]\\d)|2[0-8])/(02))|(([0-2]\\d)|30)/(04|06|09|11))|((([0-2]\\d)|3[0-1])/(01|03|05|07|08|10|12)))/(\\d{4})";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private Consola() {}
	
	public static void mostrarCabezera(String mensaje) {
		System.out.printf("%s", mensaje);
		StringBuilder subrayado = new StringBuilder();
		for (int i = 0; i < mensaje.length(); i++) {
			subrayado.append('-');
		}
		System.out.printf("%n%s", subrayado);

	}
	public static void mostrarMenu() {
		mostrarCabezera("ELIGA UNA DE LAS OPCIONES");
		for(int i = 0; i < Opcion.values().length; i++) {
			System.out.printf("%n%s. %s", i, Opcion.values()[i]);

		}
	}
	private static String leerCadena(String mensaje) {
		System.out.printf("%n%s", mensaje);
		return Entrada.cadena();

	}
	private static Integer leerEntero(String mensaje) {
		System.out.printf("%n%s", mensaje);
		return Entrada.entero();

	}
	private static LocalDate leerFecha(String mensaje) {
		System.out.printf("%n%s", mensaje);
		String fecha;
		do {
			fecha = Entrada.cadena();
		} while (!(fecha.matches(PATRON_FECHA)));
		return LocalDate.parse(fecha, FORMATO_FECHA);

	}
	public static Opcion elegirOpcion() {
		Opcion opcion = null;
		do {
		try {
			opcion = opcion.get(leerEntero("Elige una opción"));
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		} while(opcion == null);
		return opcion;
	}
	public static String leerClienteDni() {
		String dni = leerCadena("Escriba el DNI del cliente");
		return dni;
	}
	public static String leerNombre() {
		String nombre = leerCadena("Escriba el nombre del cliente");
		return nombre;
	}
	public static String leerTelefono() {
		String telefono = leerCadena("Escriba el telefono del cliente");
		return telefono;
	}
	public static Cliente leerCliente() {
		return new Cliente(leerClienteDni(), leerNombre(), leerTelefono());
	}
	public static Turismo leerTurismo() {
		String marca = leerCadena("Escriba la marca del turismo");
		String modelo = leerCadena("Escriba el modelo del turismo");
		int cilindrada = leerEntero("Escriba la cilindrada del turismo");
		String matricula = leerCadena("Escriba la matricula del turismo");

		return new Turismo(marca, modelo, cilindrada, matricula);
	}
	public static Turismo leerTurismoMatricula() {
		String matricula = leerCadena("Escriba la matricula del turismo");
		return Turismo.getTurismoConMatricula(matricula);
	}
	public static Alquiler leerAlquiler() {
		Cliente cliente = leerCliente();
		Turismo turismo = leerTurismo();
		LocalDate fechaAlquiler = leerFecha("Escriba la fecha de alquiler");
		return new Alquiler(cliente, turismo, fechaAlquiler);
	}
	public static LocalDate leerFechaDevolucion() {
		LocalDate fechadevolucion= leerFecha("Escriba la fecha de devolucion");

		return fechadevolucion;
	}
	
}
