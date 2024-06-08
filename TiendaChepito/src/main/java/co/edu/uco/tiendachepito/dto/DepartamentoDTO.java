package co.edu.uco.tiendachepito.dto;

import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;

public final class DepartamentoDTO {

	private int id;
	private String nombre;
	private PaisDTO pais;

	public DepartamentoDTO() {
		setNombre(TextHelper.EMPTY);
		setPais(PaisDTO.build());
	}

	public DepartamentoDTO(final int id, final String nombre, final PaisDTO pais) {
		setId(id);
		setNombre(nombre);
		setPais(pais);
	}

	public static final DepartamentoDTO build() {
		return new DepartamentoDTO();
	}

	public final int getId() {
		return id;
	}

	public final DepartamentoDTO setId(int id) {
		this.id = id;
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final DepartamentoDTO setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	public final PaisDTO getPais() {
		return pais;
	}

	public final DepartamentoDTO setPais(final PaisDTO pais) {
		this.pais = ObjectHelper.getObjectHelper().getDefault(pais, PaisDTO.build());
		return this;
	}
}
