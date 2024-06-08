package co.edu.uco.tiendachepito.crosscutting.exceptions.custom;

import co.edu.uco.tiendachepito.crosscutting.exceptions.TiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.exceptions.enums.Lugar;

public final class DTOTiendaChepitoException extends TiendaChepitoException {

	private static final long serialVersionUID = 1L;
	private static final Lugar lugar = Lugar.DTO;

	public DTOTiendaChepitoException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}

	public DTOTiendaChepitoException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, lugar);
	}

	public DTOTiendaChepitoException(final String mensajeTecnico, final String mensajeUsuario,
			final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}
}
