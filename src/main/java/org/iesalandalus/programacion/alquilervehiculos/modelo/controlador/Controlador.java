package org.iesalandalus.programacion.alquilervehiculos.modelo.controlador;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class Controlador {
	private Vista vista;
	private Modelo modelo;
	public Controlador(Modelo modelo, Vista vista) {
		if (modelo == null) {
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		}
		if (vista == null) {
			throw new NullPointerException("ERROR: La vista no puede ser nula.");
		}
		this.vista = vista;
		this.modelo = modelo;
	}

	public void comenzar() throws OperationNotSupportedException {
		modelo.comenzar();
		vista.comenzar();
		terminar();
	}
	
	public void terminar() {
		modelo.terminar();
		vista.terminar();
	}
	
	public void insertar(Cliente cliente) {
		modelo.insertar(cliente);
	}

	public void insertar(Turismo turismo) {
		modelo.insertar(turismo);

	}

	public void insertar(Alquiler alquiler) {
		try {
			modelo.insertar(alquiler);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public Cliente buscar(Cliente cliente) {
		return modelo.buscar(cliente);
	}

	public Turismo buscar(Turismo turismo) {
		return modelo.buscar(turismo);
	}

	public Alquiler buscar(Alquiler alquiler) {
		return modelo.buscar(alquiler);
	}
	public void modificar(Cliente cliente, String nombre, String telefono) {
		modelo.modificar(cliente, nombre, telefono);
	}
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException  {
		modelo.devolver(alquiler, fechaDevolucion);
	}
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		modelo.borrar(cliente);
	}
	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		modelo.borrar(turismo);
	}
	public void borrar(Alquiler alquiler) {
		modelo.borrar(alquiler);
	}
	public List<Cliente> getClientes() {
		return modelo.getClientes();
	}
	public List<Turismo> getTurismos() {
		return modelo.getTurismos();
	}
	public List<Alquiler> getAlquileres() {
		return modelo.getAlquileres();
	}
	public List<Alquiler> getAlquileres(Cliente cliente) {
		return modelo.getAlquileres(cliente);
	}
	public List<Alquiler> getAlquileres(Turismo turismo) {
		return modelo.getAlquileres(turismo);
	}
}
