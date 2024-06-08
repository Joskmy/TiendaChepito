package co.edu.uco.tiendachepito.business.usecase;

import java.util.List;

import co.edu.uco.tiendachepito.business.domain.PaisDomain;

public interface ConsultarPaises {
	
	List<PaisDomain> ejecutar(PaisDomain pais);
}
