package co.edu.uco.tiendachepito.entity;

import co.edu.uco.tiendachepito.crosscutting.helpers.NumericHelper;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;

public final class DepartamentoEntity {

	private int id;
	private String nombre;
	private PaisEntity pais;

	private DepartamentoEntity(final int id) {
		setId(id);
		setNombre(TextHelper.EMPTY);
		setPais(PaisEntity.build());
	}

	private DepartamentoEntity(final int id, final String nombre, final PaisEntity pais) {
		setId(id);
		setNombre(nombre);
		setPais(pais);
	}

	public static final DepartamentoEntity build(final int id) {
		return new DepartamentoEntity(id);
	}

	public static final DepartamentoEntity build(final int id, final String nombre, final PaisEntity pais) {
		return new DepartamentoEntity(id, nombre, pais);
	}

	protected static final DepartamentoEntity build() {
		return new DepartamentoEntity(NumericHelper.ZERO);
	}

	private final void setId(final int id) {
		this.id = id;
	}

	private final void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}

	private final void setPais(final PaisEntity pais) {
		this.pais = ObjectHelper.getObjectHelper().getDefault(pais, PaisEntity.build());
	}

	public final int getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}

	public final PaisEntity getPais() {
		return pais;
	}
}
