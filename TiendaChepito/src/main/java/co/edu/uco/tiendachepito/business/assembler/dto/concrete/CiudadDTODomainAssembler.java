package co.edu.uco.tiendachepito.business.assembler.dto.concrete;

import java.util.List;

import co.edu.uco.tiendachepito.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.tiendachepito.business.domain.CiudadDomain;
import co.edu.uco.tiendachepito.business.domain.DepartamentoDomain;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.dto.CiudadDTO;
import co.edu.uco.tiendachepito.dto.DepartamentoDTO;

public final class CiudadDTODomainAssembler implements DTODomainAssembler<CiudadDomain, CiudadDTO> {

	private static final DTODomainAssembler<CiudadDomain, CiudadDTO> instancia = new CiudadDTODomainAssembler();

	private static final DTODomainAssembler<DepartamentoDomain, DepartamentoDTO> departamentoAssembler = DepartamentoDTODomainAssembler
			.obtenerInstancia();

	private CiudadDTODomainAssembler() {
		super();
	}

	public static final DTODomainAssembler<CiudadDomain, CiudadDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public final CiudadDomain ensamblarDominio(final CiudadDTO dto) {
		var ciudadDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new CiudadDTO());
		var departamentoDomain = departamentoAssembler.ensamblarDominio(ciudadDtoTmp.getDepartamento());
		return CiudadDomain.crear(ciudadDtoTmp.getId(), ciudadDtoTmp.getNombre(), departamentoDomain);
	}

	@Override
	public final CiudadDTO ensamblarDTO(final CiudadDomain dominio) {
		var ciudadDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, CiudadDomain.crear());
		var departamentoDTO = departamentoAssembler.ensamblarDTO(ciudadDomainTmp.getDepartamento());

		return CiudadDTO.build().setId(ciudadDomainTmp.getId()).setNombre(ciudadDomainTmp.getNombre()).setDepartamento(departamentoDTO);
	}

	@Override
	public List<CiudadDTO> ensamblarListaDTO(List<CiudadDomain> listaDominios) {
		// TODO Auto-generated method stub
		return null;
	}

}
