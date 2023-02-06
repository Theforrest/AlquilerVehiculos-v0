package org.iesalandalus.programacion.alquilervehiculos.vista;

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
	}
	private boolean esOrdinalValido(int ordinal) {
		return ordinal > 0 && Opcion.values().length > ordinal;
	}
	
	public Opcion get(int ordinal) {
		if (!(esOrdinalValido(ordinal))) {
			throw new IllegalArgumentException("ERROR: El ordinel no es valido.");
		}
		esOrdinalValido(ordinal);
		return Opcion.values()[ordinal];
	}
	public String toString() {
		return String.format("%s", texto);
	}
}