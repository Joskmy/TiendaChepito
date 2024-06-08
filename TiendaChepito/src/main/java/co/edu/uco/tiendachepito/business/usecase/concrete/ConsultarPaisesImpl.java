package co.edu.uco.tiendachepito.business.usecase.concrete;

import java.util.List;

import co.edu.uco.tiendachepito.business.assembler.entity.concrete.PaisEntityDomainAssembler;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.business.usecase.ConsultarPaises;
import co.edu.uco.tiendachepito.data.dao.factory.DAOFactory;

public final class ConsultarPaisesImpl implements ConsultarPaises {

	private final DAOFactory factory;

	public ConsultarPaisesImpl(final DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public final List<PaisDomain> ejecutar(final PaisDomain pais) {

		var paisEntity = PaisEntityDomainAssembler.obtenerInstancia().ensablarEntidad(pais);
		var resultados = factory.getPaisDAO().consultar(paisEntity);

		return PaisEntityDomainAssembler.obtenerInstancia().ensamblarListaDominios(resultados);
	}

}
