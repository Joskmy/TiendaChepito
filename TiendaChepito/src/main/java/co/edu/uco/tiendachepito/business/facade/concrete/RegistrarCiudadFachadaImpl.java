package co.edu.uco.tiendachepito.business.facade.concrete;

import co.edu.uco.tiendachepito.business.assembler.dto.concrete.CiudadDTODomainAssembler;
import co.edu.uco.tiendachepito.business.facade.RegistrarCiudadFachada;
import co.edu.uco.tiendachepito.business.usecase.RegistrarCiudad;
import co.edu.uco.tiendachepito.business.usecase.concrete.RegistrarCiudadImpl;
import co.edu.uco.tiendachepito.crosscutting.exceptions.TiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.exceptions.custom.BusinessTiendaChepitoException;
import co.edu.uco.tiendachepito.data.dao.factory.DAOFactory;
import co.edu.uco.tiendachepito.data.dao.factory.enums.Factory;
import co.edu.uco.tiendachepito.dto.CiudadDTO;

public class RegistrarCiudadFachadaImpl implements RegistrarCiudadFachada {

	private DAOFactory factory;

	public RegistrarCiudadFachadaImpl() {
		factory = DAOFactory.getFactory(Factory.AZURESQL);
	}

	@Override
	public void ejecutar(final CiudadDTO ciudad) {
		try {
			factory.iniciarTransaccion();
			
			var ciudadDomain = CiudadDTODomainAssembler.obtenerInstancia().ensamblarDominio(ciudad);
			
			final RegistrarCiudad useCase = new RegistrarCiudadImpl(factory);
			useCase.ejecutar(ciudadDomain);
			
			factory.confirmarTransaccion();
		} catch (final TiendaChepitoException exception) {
			factory.cancelarTransaccion();
			throw exception;
		} catch (final Exception exception) {
			factory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema tratando de Registrar la información de la nueva ciudad...";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de registrar la infromación  de la nueva ciudad en él método ejecutar. Por favor revise la traza completa del problema";
			throw new BusinessTiendaChepitoException(mensajeTecnico, mensajeUsuario);
		} finally {
			factory.cerrarConexion();
		}

	}
}