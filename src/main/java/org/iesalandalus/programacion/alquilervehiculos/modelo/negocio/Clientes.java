package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

public class Clientes {

	private List<Cliente> coleccionClientes;

	public Clientes() {
		coleccionClientes = new ArrayList<>();
	}

	public List<Cliente> get() {
		List<Cliente> copiaClientes = new ArrayList<>();
		for (Cliente cliente : coleccionClientes) {
			copiaClientes.add(cliente);
		}
		return copiaClientes;
	}

	public int getCantidad() {
		return coleccionClientes.size();
	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}
		if (coleccionClientes.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
		}
		coleccionClientes.add(cliente);
	}

	public Cliente buscar(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}
		if (!(coleccionClientes.contains(cliente))) {
			return null;
		}
		return coleccionClientes.get(coleccionClientes.indexOf(cliente));
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
		if (!coleccionClientes.remove(buscar(cliente))) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}
	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}
		if (buscar(cliente) == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}

		if (!((nombre == null || nombre.isBlank()) && (telefono == null || telefono.isBlank()))) {

			if (nombre == null || nombre.isBlank()) {
				buscar(cliente).setTelefono(telefono);
			} else {
				if (telefono == null || telefono.isBlank()) {
					buscar(cliente).setNombre(nombre);
				} else {
					buscar(cliente).setNombre(nombre);
					buscar(cliente).setTelefono(telefono);
				}
			}
		
		}

	}
}
