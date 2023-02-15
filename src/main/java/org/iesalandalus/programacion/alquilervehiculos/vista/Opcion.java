package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

public enum Opcion {
	SALIR("Salir"), INSERTAR_CLIENTE("Insertar cliente"), INSERTAR_TURISMO("Insertar turismo"),
	INSERTAR_ALQUILER("Insertar alquiler"), BUSCAR_CLIENTE("Buscar cliente"), BUSCAR_TURISMO("Buscar turismo"),
	BUSCAR_ALQUILER("Buscar alquiler"), MODIFICAR_CLIENTE("Modificar cliente"), DEVOLVER_ALQUILER("Devolver alquiler"),
	BORRAR_CLIENTE("Borrar cliente"), BORRAR_TURISMO("Borrar turismo"), BORRAR_ALQUILER("Borrar alquiler"),
	LISTAR_CLIENTES("Listar clientes"), LISTAR_TURISMO("Listar turismos"), LISTAR_ALQUILERES("Listar alquileres"),
	LISTAR_ALQUILERES_CLIENTE("Listar alquileres de cliente"),
	LISTAR_ALQUILERES_TURISMO("Listar alquileres de turismo");

	private String texto;

	private Opcion(String texto) {
		if (texto == null) {
			throw new NullPointerException("ERROR: El texto no puede ser nulo.");
		}
		if (texto.isBlank()) {
			throw new IllegalArgumentException("ERROR: El texto no puede estar en blanco.");
		}
		this.texto = texto;
	}
	private static boolean esOrdinalValido(int ordinal) {
		return ordinal >= 0 && Opcion.values().length > ordinal;
	}
	 
	public static Opcion get(int ordinal) throws OperationNotSupportedException {
		if (!(esOrdinalValido(ordinal))) {
			throw new OperationNotSupportedException("ERROR: El ordinal no es valido.");
		}
		return Opcion.values()[ordinal];
	}
	@Override
	public String toString() {
		return String.format("%d. %s", ordinal(), texto);
	}
}
