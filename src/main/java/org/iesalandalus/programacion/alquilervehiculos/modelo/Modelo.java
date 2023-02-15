package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Modelo {

	private Clientes clientes;
	private Turismos turismos;
	private Alquileres alquileres;
	
	
	
	public void comenzar() {
		clientes = new Clientes();
		turismos = new Turismos();
		alquileres= new Alquileres();
	}
	public void terminar() {
		System.out.printf("%nEL modelo ha terminado%n");
	}
	
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		
		
		clientes.insertar(new Cliente(cliente));
		
	}
	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		
		turismos.insertar(new Turismo(turismo));
		
	}
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}
		if (clientes.buscar(alquiler.getCliente()) == null) {
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}
		if (turismos.buscar(alquiler.getTurismo()) == null) {
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		}
		

		
		alquileres.insertar(new Alquiler(clientes.buscar(alquiler.getCliente()), turismos.buscar(alquiler.getTurismo()), alquiler.getFechaAlquiler()));
		
	}
	public Cliente buscar(Cliente cliente) {
		if (clientes.buscar(cliente) == null) {
			return null;

		}
		return new Cliente(clientes.buscar(cliente));
	}
	public Turismo buscar(Turismo turismo) {
		if (turismos.buscar(turismo) == null) {
			return null;

		}
		return new Turismo(turismos.buscar(turismo));
	}
	public Alquiler buscar(Alquiler alquiler) {
		if (alquileres.buscar(alquiler) == null) {
			return null;

		}
		return new Alquiler(alquileres.buscar(alquiler));
	}
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		
		clientes.modificar(cliente, nombre, telefono);
		
	}
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException  {
		Alquiler alquilerTemporal = alquileres.buscar(alquiler);
		if (alquilerTemporal == null) {
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		}
		
		alquilerTemporal.devolver(fechaDevolucion);
		
	}
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		
		for (Alquiler alquiler : alquileres.get(cliente)) {
			
			alquileres.borrar(alquiler);
		
	}	
		clientes.borrar(cliente);
		
		
	}
	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		for (Alquiler alquiler : alquileres.get(turismo)) {
			
			alquileres.borrar(alquiler);
			
		}
			turismos.borrar(turismo);
		
		
		
	}
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		
		alquileres.borrar(alquiler);
		
	}
	public List<Cliente> getClientes() {
		List<Cliente> copiaClientes = new ArrayList<>();
		for (Cliente cliente : clientes.get()) {
			copiaClientes.add(new Cliente(cliente));
		}
		return copiaClientes;
	}
	public List<Turismo> getTurismos() {
		List<Turismo> copiaTurismos = new ArrayList<>();
		for (Turismo turismo : turismos.get()) {
			copiaTurismos.add(new Turismo(turismo));
		}
		return copiaTurismos;
	}
	public List<Alquiler> getAlquileres() {
		List<Alquiler> copiaAlquileres = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get()) {
			copiaAlquileres.add(new Alquiler(alquiler));
		}
		return copiaAlquileres;
	}
	public List<Alquiler> getAlquileres(Cliente cliente) {
		List<Alquiler> copiaAlquileres = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get(cliente)) {
			copiaAlquileres.add(new Alquiler(alquiler));
		}
		return copiaAlquileres;
	}
	public List<Alquiler> getAlquileres(Turismo turismo) {
		List<Alquiler> copiaAlquileres = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get(turismo)) {
			copiaAlquileres.add(new Alquiler(alquiler));
		}
		return copiaAlquileres;
	}
}
