package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;

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
	public void comenzar() {
		Opcion opcion;
		do {
		Consola.mostrarMenu();
		opcion = Consola.elegirOpcion();
		ejecutar(opcion);
		} while(opcion.equals(Opcion.SALIR));
		
	}
	
	public void terminar() {
		System.out.print("Adios");
	}
	private void ejecutar(Opcion opcion) {
		switch (opcion) {
		case SALIR:
			break;
		case INSERTAR_CLIENTE:
			insertarCliente();;
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
	
	private void insertarCliente() {
		Consola.mostrarCabezera("Insertar cliente");
		Cliente cliente = Consola.leerCliente();
		controlador.insertar(cliente);
	}

	private void insertarTurismo() {
		Consola.mostrarCabezera("Insertar turismo");
		Turismo turismo = Consola.leerTurismo();
		controlador.insertar(turismo);

	}

	private void insertarAlquiler() {
		Consola.mostrarCabezera("Insertar turismo");
		Alquiler alquiler = Consola.leerAlquiler();
		controlador.insertar(alquiler);

	}
	private void buscarCliente() {
		Consola.mostrarCabezera("Buscar cliente");
		Cliente cliente = Consola.leerCliente();
		controlador.buscar(cliente);
	}

	private void buscarTurismo() {
		Consola.mostrarCabezera("Buscar turismo");
		Turismo turismo = Consola.leerTurismo();
		controlador.buscar(turismo);
	}

	private void buscarAlquiler() {
		Consola.mostrarCabezera("Buscar alquiler");
		Alquiler alquiler = Consola.leerAlquiler();
		controlador.buscar(alquiler);
	}
	private void modificarCliente() {
		Consola.mostrarCabezera("Modificar cliente");
		Cliente cliente = Consola.leerCliente();
		String nombre = Consola.leerNombre();
		String telefono = Consola.leerTelefono();

		controlador.modificar(cliente, nombre, telefono);
	}
	private void devolverAlquiler()   {
		Consola.mostrarCabezera("Devolver alquiler");
		Alquiler alquiler = Consola.leerAlquiler();
		LocalDate fechaDevolucion = Consola.leerFechaDevolucion();

		try {
			controlador.devolver(alquiler, fechaDevolucion);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	private void borrarCliente()  {
		Consola.mostrarCabezera("Borrar cliente");
		Cliente cliente = Consola.leerCliente();
		try {
			controlador.borrar(cliente);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	private void borrarTurismo()  {
		Consola.mostrarCabezera("Borrar turismo");
		Turismo turismo = Consola.leerTurismo();
		try {
			controlador.borrar(turismo);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	private void borrarAlquiler()  {
		Consola.mostrarCabezera("Borrar alquiler");
		Alquiler alquiler = Consola.leerAlquiler();
		controlador.borrar(alquiler);
	}
	private void listarClientes() {
		Consola.mostrarCabezera("Listar Clientes");
		controlador.getClientes();
	}
	private void listarTurismos() {
		Consola.mostrarCabezera("Listar Turismos");
		controlador.getTurismos();	
	}
	private void listarAlquileres() {
		Consola.mostrarCabezera("Listar alquileres");
		controlador.getAlquileres();
	}
	private void listarAlquileresCliente() {
		Consola.mostrarCabezera("Listar alquileres de cliente");
		Cliente cliente = Consola.leerCliente();
		controlador.getAlquileres(cliente);
	}
	private void listarAlquileresTurismo() {
		Consola.mostrarCabezera("Listar alquileres de cliente");
		Turismo turismo = Consola.leerTurismo();
		controlador.getAlquileres(turismo);
	}
}
