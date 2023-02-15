package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Vista {

	private Controlador controlador;

	public void setControlador(Controlador controlador) {
		if (controlador == null) {
			throw new NullPointerException("ERROR: El controlador no puede ser nulo.");
		}
		this.controlador = controlador;
	}
	public void comenzar()  {
		Opcion opcion;
		do {
		Consola.mostrarMenu();
		opcion = Consola.elegirOpcion();
		try {
			ejecutar(opcion);
		} catch (IllegalArgumentException | OperationNotSupportedException e) {
			System.out.printf("%n%s%n%n", e.getMessage());
		}
		} while(!(opcion.equals(Opcion.SALIR)));
		
	}
	
	public void terminar() {
		System.out.print("Adios");
	}
	private void ejecutar(Opcion opcion) throws OperationNotSupportedException {
		Consola.mostrarCabezera(opcion.toString());
		switch (opcion) {
		case SALIR:
			break;
		case INSERTAR_CLIENTE:
			insertarCliente();
			break;
		case INSERTAR_TURISMO:
			insertarTurismo();
			break;
		case INSERTAR_ALQUILER:
			insertarAlquiler();
			break;
		
		case BUSCAR_CLIENTE:
			buscarCliente();
			break;
		case BUSCAR_TURISMO:
			buscarTurismo();
			break;
		case BUSCAR_ALQUILER:
			buscarAlquiler();
			break;
		case MODIFICAR_CLIENTE:
			modificarCliente();
			break;
		case DEVOLVER_ALQUILER:
			devolverAlquiler();
			break;
		case BORRAR_CLIENTE:
			borrarCliente();
			break;
		case BORRAR_TURISMO:
			borrarTurismo();
			break;
		case BORRAR_ALQUILER:
			borrarAlquiler();
			break;
		
		case LISTAR_CLIENTES:
			listarClientes();
			break;
		case LISTAR_TURISMO:
			listarTurismos();
			break;
		case LISTAR_ALQUILERES:
			listarAlquileres();
			break;
		case LISTAR_ALQUILERES_CLIENTE:
			listarAlquileresCliente();
			break;
		case LISTAR_ALQUILERES_TURISMO:
			listarAlquileresTurismo();
			
			break;	
		default:
			System.out.print("Algo a ido mal");
			break;
			
	}
	}
	
	private void insertarCliente() throws OperationNotSupportedException {
		Cliente cliente = Consola.leerCliente();
		controlador.insertar(cliente);
	}

	private void insertarTurismo() throws OperationNotSupportedException {
		Turismo turismo = Consola.leerTurismo();
		controlador.insertar(turismo);

	}

	private void insertarAlquiler() {
		Alquiler alquiler = Consola.leerAlquiler();
		try {
			controlador.insertar(alquiler);
		} catch (OperationNotSupportedException e) {
			System.out.print(e.getMessage());
		}

	}
	private void buscarCliente() {
		Cliente cliente = Consola.leerClienteDni();
		System.out.printf("%s%n",(controlador.buscar(cliente) == null) ? "Cliente no encontrado" : controlador.buscar(cliente));
	}

	private void buscarTurismo() {
		Turismo turismo = Consola.leerTurismoMatricula();
		System.out.printf("%s%n",(controlador.buscar(turismo) == null) ? "Turismo no encontrado" : controlador.buscar(turismo));
	}

	private void buscarAlquiler() {
		Alquiler alquiler = Consola.leerAlquiler();
		System.out.printf("%s%n", (controlador.buscar(alquiler) == null) ? "Alquiler no encontrado" : controlador.buscar(alquiler));
	}
	private void modificarCliente() throws OperationNotSupportedException {
		Cliente cliente = Consola.leerClienteDni();
		String nombre = Consola.leerNombre();
		String telefono = Consola.leerTelefono();

		controlador.modificar(cliente, nombre, telefono);
	}
	private void devolverAlquiler()   {
		Alquiler alquiler = Consola.leerAlquiler();
		LocalDate fechaDevolucion = Consola.leerFechaDevolucion();

		try {
			controlador.devolver(alquiler, fechaDevolucion);
		} catch (OperationNotSupportedException e) {
			e.getMessage();
		}
	}
	private void borrarCliente()  {
		Cliente cliente = Consola.leerClienteDni();
		try {
			controlador.borrar(cliente);
		} catch (OperationNotSupportedException e) {
			e.getMessage();
		}
	}
	private void borrarTurismo()  {
		Turismo turismo = Consola.leerTurismoMatricula();
		try {
			controlador.borrar(turismo);
		} catch (OperationNotSupportedException e) {
			e.getMessage();
		}
	}
	private void borrarAlquiler() throws OperationNotSupportedException  {
		Alquiler alquiler = Consola.leerAlquiler();
		controlador.borrar(alquiler);
	}
	private void listarClientes() {
		List<Cliente> clientes = controlador.getClientes();
		for (int i = 0; i < clientes.size(); i++) {
			System.out.printf("%d. %s%n", i+1, clientes.get(i));
		}
	}
	private void listarTurismos() {
		List<Turismo> turismos = controlador.getTurismos();	
		for (int i = 0; i < turismos.size(); i++) {
			System.out.printf("%d. %s%n", i+1, turismos.get(i));
		}
	}
	private void listarAlquileres() {
		List<Alquiler> alquileres = controlador.getAlquileres();	
		for (int i = 0; i < alquileres.size(); i++) {
			System.out.printf("%d. %s%n", i+1, alquileres.get(i));
		}
	}
	private void listarAlquileresCliente() {
		Cliente cliente = Consola.leerClienteDni();
		List<Alquiler> alquileres = controlador.getAlquileres(cliente);	
		for (int i = 0; i < alquileres.size(); i++) {
			System.out.printf("%d. %s%n", i+1, alquileres.get(i));
		}
	}
	private void listarAlquileresTurismo() {
		Turismo turismo = Consola.leerTurismoMatricula();
		List<Alquiler> alquileres = controlador.getAlquileres(turismo);	
		for (int i = 0; i < alquileres.size(); i++) {
			System.out.printf("%d. %s%n", i+1, alquileres.get(i));
		}
	}
}
