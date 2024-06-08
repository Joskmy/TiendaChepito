package co.edu.uco.tiendachepito.api.response.pais;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.tiendachepito.api.response.Response;
import co.edu.uco.tiendachepito.dto.PaisDTO;

public class PaisResponse extends Response<PaisDTO> {
	
	public static final PaisResponse build(final List<String> mensajes,final List<PaisDTO> datos) {
		PaisResponse instance = new PaisResponse();
		instance.setMensajes(mensajes);
		instance.setDatos(datos);
		
		return instance;
	}

	
	public static final PaisResponse build(final List<PaisDTO> datos) {
		PaisResponse instance = new PaisResponse();
		instance.setMensajes(new ArrayList<>());
		instance.setDatos(datos);
		
		return instance;
	}
	
	public static final PaisResponse build() {
		PaisResponse instance = new PaisResponse();
		instance.setMensajes(new ArrayList<>());
		instance.setDatos(new ArrayList<>());
		
		return instance;
	}
}
