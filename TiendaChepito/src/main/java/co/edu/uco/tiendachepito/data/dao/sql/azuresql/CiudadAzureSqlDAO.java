package co.edu.uco.tiendachepito.data.dao.sql.azuresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.tiendachepito.data.dao.CiudadDAO;
import co.edu.uco.tiendachepito.data.dao.sql.SqlConnection;
import co.edu.uco.tiendachepito.entity.CiudadEntity;

public final class CiudadAzureSqlDAO extends SqlConnection implements CiudadDAO {

	public CiudadAzureSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void crear(final CiudadEntity entidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public final void actualizar(final CiudadEntity entidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public final void eliminar(final int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public final List<CiudadEntity> consultar(final CiudadEntity entidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
