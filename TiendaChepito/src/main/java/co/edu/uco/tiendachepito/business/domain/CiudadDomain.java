package co.edu.uco.tiendachepito.business.domain;

import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;

public class CiudadDomain {
	private int id;
	private String nombre;
	private DepartamentoDomain departamento;

	
	
	private CiudadDomain(final int id, final String nombre, final DepartamentoDomain departamento) {
		setId(id);
		setNombre(nombre);
		setDepartamento(departamento);
	}

	private CiudadDomain() {
		setNombre(TextHelper.EMPTY);
		setDepartamento(DepartamentoDomain.crear());
	}

	public static final CiudadDomain crear(final int id, final String nombre, final DepartamentoDomain departamento) {
		return new CiudadDomain(id, nombre, departamento);
	}

	public static final CiudadDomain crear() {
		return new CiudadDomain();
	}

	private final void setId(final int id) {
		this.id = id;
	}

	private final void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}

	

	private final void setDepartamento(final DepartamentoDomain departamento) {
		this.departamento = ObjectHelper.getObjectHelper().getDefault(departamento, DepartamentoDomain.crear());
	}

	public final DepartamentoDomain getDepartamento() {
		return departamento;
	}

	public final int getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}
}
