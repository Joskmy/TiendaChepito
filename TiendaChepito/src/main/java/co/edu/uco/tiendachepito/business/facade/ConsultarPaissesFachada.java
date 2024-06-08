package co.edu.uco.tiendachepito.business.facade;

import java.util.List;

import co.edu.uco.tiendachepito.dto.PaisDTO;

public interface ConsultarPaissesFachada {
	public interface ConsultarPaisesFachada {
		List<PaisDTO> execute(PaisDTO pais);
	}
}
