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
	
	public Modelo() {
		
	}
	
	public void comenzar() {
		clientes = new Clientes();
		turismos = new Turismos();
		alquileres= new Alquileres();
	}
	public void terminar() {
		System.out.printf("%nEL modelo ha terminado%n");
	}
	
	public void insertar(Cliente cliente) {
		
		try {
			clientes.insertar(new Cliente(cliente));
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	public void insertar(Turismo turismo) {
		try {
			turismos.insertar(new Turismo(turismo));;
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
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
		

		try {
			alquileres.insertar(new Alquiler(clientes.buscar(alquiler.getCliente()), turismos.buscar(alquiler.getTurismo()), alquiler.getFechaAlquiler()));;
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
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
	public void modificar(Cliente cliente, String nombre, String telefono) {
		try {
			clientes.modificar(cliente, nombre, telefono);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException  {
		Alquiler alquilerTemporal = alquileres.buscar(alquiler);
		if (alquilerTemporal == null) {
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		}
		try {
			alquilerTemporal.devolver(fechaDevolucion);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		
		for (Alquiler alquiler : alquileres.get(cliente)) {
			
			alquileres.borrar(alquiler);
		
	}	
		clientes.borrar(cliente);
		
		
	}
	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		for (Alquiler alquiler : alquileres.get(turismo)) {
			try {
				alquileres.borrar(alquiler);
			} catch (OperationNotSupportedException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
			turismos.borrar(turismo);;
		
		
		
	}
	public void borrar(Alquiler alquiler) {
		try {
			alquileres.borrar(alquiler);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
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
