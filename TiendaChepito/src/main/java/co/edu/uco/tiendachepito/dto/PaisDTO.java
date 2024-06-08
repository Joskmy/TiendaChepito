package co.edu.uco.tiendachepito.dto;

import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;

public final class PaisDTO {

	private int id;
	private String nombre;

	public PaisDTO() {
		setNombre(TextHelper.EMPTY);
	}

	public PaisDTO(final int id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}

	public static final PaisDTO build() {
		return new PaisDTO();
	}

	public final int getId() {
		return id;
	}

	public final PaisDTO setId(final int id) {
		this.id = id;
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final PaisDTO setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}
}