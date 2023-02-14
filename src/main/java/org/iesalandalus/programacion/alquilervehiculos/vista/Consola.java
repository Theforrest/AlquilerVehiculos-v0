package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private static final String PATRON_FECHA = "dd-MM-yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);
	private Consola() {}
	
	public static void mostrarCabezera(String mensaje) {
		System.out.printf("%n%s", mensaje);
		StringBuilder subrayado = new StringBuilder();
		for (int i = 0; i < mensaje.length(); i++) {
			subrayado.append('-');
		}
		System.out.printf("%n%s%n", subrayado);

	}
	public static void mostrarMenu() {
		mostrarCabezera("Este es un programa para manejar los alquileres de turismos realizados por clientes");
		for(int i = 0; i < Opcion.values().length; i++) {
			System.out.printf("%n%s. %s", i, Opcion.values()[i]);

		}
	}
	private static String leerCadena(String mensaje) {
		System.out.printf("%n%s: ", mensaje);
		return Entrada.cadena();

	}
	private static Integer leerEntero(String mensaje) {
		System.out.printf("%n%s: ", mensaje);
		return Entrada.entero();

	}
	private static LocalDate leerFecha(String mensaje) {
		String fecha;
		
			
			do {
				System.out.printf("%n%s: ", mensaje);
				fecha = Entrada.cadena();
			try {
	           return  LocalDate.parse(fecha, FORMATO_FECHA);
	        } catch (DateTimeParseException e) {
	        	System.out.printf("%nFormato de fecha incorrecta");
	        	fecha = null;
	        }} while (fecha == null);
			return null;
		
	}
	public static Opcion elegirOpcion()  {
		Opcion opcion = Opcion.BUSCAR_CLIENTE;
		int i;
		do {
			i = leerEntero("Elige una opción");
			try {
				opcion = opcion.get(i);
			} catch (OperationNotSupportedException e) {
				System.out.printf("%n%s%n%n", e.getMessage());
			}
		
		} while(i< 0 || i > Opcion.values().length);

		return opcion;
	}
	public static Cliente leerClienteDni() {
		String dni = leerCadena("Escriba el DNI del cliente");
		return Cliente.getClienteConDni(dni);
	}
	public static String leerNombre() {
		return leerCadena("Escriba el nombre del cliente");
	}
	public static String leerTelefono() {
		return leerCadena("Escriba el telefono del cliente");
	}
	public static Cliente leerCliente() {
		return new Cliente(leerNombre() , leerCadena("Escriba el dni"), leerTelefono());
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
		Cliente cliente = leerClienteDni();
		Turismo turismo = leerTurismoMatricula();
		LocalDate fechaAlquiler = leerFecha("Escriba la fecha de alquiler");
		return new Alquiler(cliente, turismo, fechaAlquiler);
	}
	public static LocalDate leerFechaDevolucion() {
		return leerFecha("Escriba la fecha de devolucion");
	}
	
}
