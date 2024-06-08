package co.edu.uco.tiendachepito.business.domain;

import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;

public class DepartamentoDomain {
	private int id;
	private String nombre;
	private PaisDomain pais;

	private DepartamentoDomain(final int id, final String nombre, final PaisDomain pais) {
		setId(id);
		setNombre(nombre);
		setPais(pais);
	}

	private DepartamentoDomain() {
		setNombre(TextHelper.EMPTY);
		setPais(PaisDomain.crear());
	}

	public static final DepartamentoDomain crear(final int id, final String nombre, final PaisDomain pais) {
		return new DepartamentoDomain(id, nombre, pais);
	}

	public static final DepartamentoDomain crear() {
		return new DepartamentoDomain();
	}

	private final void setId(final int id) {
		this.id = id;
	}

	private final void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}

	private final void setPais(final PaisDomain pais) {
		this.pais = ObjectHelper.getObjectHelper().getDefault(pais, PaisDomain.crear());
	}

	public final PaisDomain getPais() {
		return pais;
	}

	public final int getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}
}
