package co.edu.uco.tiendachepito.data.dao;

import co.edu.uco.tiendachepito.data.dao.general.ActualizarDAO;
import co.edu.uco.tiendachepito.data.dao.general.ConsultarDAO;
import co.edu.uco.tiendachepito.data.dao.general.CrearDAO;
import co.edu.uco.tiendachepito.data.dao.general.EliminarDAO;
import co.edu.uco.tiendachepito.entity.CiudadEntity;

public interface CiudadDAO
		extends CrearDAO<CiudadEntity>, ActualizarDAO<CiudadEntity>, EliminarDAO, ConsultarDAO<CiudadEntity> {

}
