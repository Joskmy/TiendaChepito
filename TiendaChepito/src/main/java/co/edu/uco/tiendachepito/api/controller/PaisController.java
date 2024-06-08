package co.edu.uco.tiendachepito.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.tiendachepito.api.response.pais.PaisResponse;
import co.edu.uco.tiendachepito.business.facade.ConsultarPaissesFachada.ConsultarPaisesFachada;
import co.edu.uco.tiendachepito.business.facade.concrete.ConsultarPaisesFachadaImpl;
import co.edu.uco.tiendachepito.crosscutting.exceptions.TiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.helpers.NumericHelper;
import co.edu.uco.tiendachepito.dto.PaisDTO;

@RestController
@RequestMapping("/api/v1/paises")
public class PaisController {

	@GetMapping("/dummy")
	public PaisDTO getDummy() {
		return PaisDTO.build();
	}

	@GetMapping
	public ResponseEntity<PaisResponse> consultar(@RequestParam(required = false, defaultValue = "0") String id, @RequestParam(required = false, defaultValue = "") String nombre) {

		PaisResponse paisResponse = PaisResponse.build();
		HttpStatus httpStatusResponse = HttpStatus.OK;

		
		
		try {
			
			final var paisDtpFilter = PaisDTO.build().setId(NumericHelper.convertToInt(id)).setNombre(nombre);
			final ConsultarPaisesFachada fachada = new ConsultarPaisesFachadaImpl();
			paisResponse.setDatos(fachada.execute(paisDtpFilter));
			paisResponse.getMensajes().add("Paises consultados exitosamente");

		} catch (final TiendaChepitoException exception) {
			exception.printStackTrace();
			paisResponse.getMensajes().add(exception.getMensajeUsuario());
			httpStatusResponse = HttpStatus.BAD_REQUEST;

		} catch (final Exception exception) {
			exception.printStackTrace();
			paisResponse.getMensajes()
					.add("Se ha presentado un mensaje inesperado tratando de consultar la información de los paises");
			httpStatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(paisResponse, httpStatusResponse);
	}

	@PostMapping
	public ResponseEntity<PaisResponse> crear(@RequestBody PaisDTO pais) {

		PaisResponse paisResponse = PaisResponse.build();
		HttpStatus httpStatusResponse = HttpStatus.OK;
		try {
			// Llamars
			paisResponse.getDatos().add(pais);
			paisResponse.getMensajes().add("Pais creado exitosamente");

		} catch (final TiendaChepitoException exception) {
			exception.printStackTrace();
			paisResponse.getMensajes().add(exception.getMensajeUsuario());
			httpStatusResponse = HttpStatus.BAD_REQUEST;

		} catch (final Exception exception) {
			exception.printStackTrace();
			paisResponse.getMensajes()
					.add("Se ha presentado un mensaje inesperado tratando de consultar la información de los paises");
			httpStatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(paisResponse, httpStatusResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<PaisResponse> eliminar(@PathVariable int id) {

		PaisResponse paisResponse = PaisResponse.build();
		HttpStatus httpStatusResponse = HttpStatus.OK;
		try {
			// Llamars
			paisResponse.getDatos().add(PaisDTO.build().setId(id));
			paisResponse.getMensajes().add("Pais eliminado exitosamente");

		} catch (final TiendaChepitoException exception) {
			exception.printStackTrace();
			paisResponse.getMensajes().add(exception.getMensajeUsuario());
			httpStatusResponse = HttpStatus.BAD_REQUEST;

		} catch (final Exception exception) {
			exception.printStackTrace();
			paisResponse.getMensajes()
					.add("Se ha presentado un mensaje inesperado tratando de consultar la información de los paises");
			httpStatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(paisResponse, httpStatusResponse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PaisResponse> modificar(@PathVariable int id, @RequestBody PaisDTO pais) {

		PaisResponse paisResponse = PaisResponse.build();
		HttpStatus httpStatusResponse = HttpStatus.OK;
		try {
			pais.setId(id);
			// Llamars
			paisResponse.getDatos().add(pais);
			paisResponse.getMensajes().add("Pais modificado exitosamente");

		} catch (final TiendaChepitoException exception) {
			exception.printStackTrace();
			paisResponse.getMensajes().add(exception.getMensajeUsuario());
			httpStatusResponse = HttpStatus.BAD_REQUEST;

		} catch (final Exception exception) {
			exception.printStackTrace();
			paisResponse.getMensajes()
					.add("Se ha presentado un mensaje inesperado tratando de consultar la información de los paises");
			httpStatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(paisResponse, httpStatusResponse);
	}

}
