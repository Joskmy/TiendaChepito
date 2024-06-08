package co.edu.uco.tiendachepito.data.dao.sql.azuresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.tiendachepito.data.dao.DepartamentoDAO;
import co.edu.uco.tiendachepito.data.dao.sql.SqlConnection;
import co.edu.uco.tiendachepito.entity.DepartamentoEntity;

public final class DepartamentoAzureSqlDAO extends SqlConnection implements DepartamentoDAO {

	public DepartamentoAzureSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void crear(final DepartamentoEntity entidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public final void actualizar(final DepartamentoEntity entidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public final void eliminar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public final List<DepartamentoEntity> consultar(final DepartamentoEntity entidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
