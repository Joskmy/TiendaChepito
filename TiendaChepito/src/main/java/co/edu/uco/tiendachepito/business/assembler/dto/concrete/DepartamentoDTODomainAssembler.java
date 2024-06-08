package co.edu.uco.tiendachepito.business.assembler.dto.concrete;

import java.util.List;

import co.edu.uco.tiendachepito.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.tiendachepito.business.domain.DepartamentoDomain;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.dto.DepartamentoDTO;
import co.edu.uco.tiendachepito.dto.PaisDTO;

public final class DepartamentoDTODomainAssembler implements DTODomainAssembler<DepartamentoDomain, DepartamentoDTO>{
	
	private static final DTODomainAssembler<DepartamentoDomain, DepartamentoDTO> instancia = new DepartamentoDTODomainAssembler();
	
	private static final DTODomainAssembler<PaisDomain, PaisDTO> paisAssembler = PaisDTODomainAssembler.obtenerInstancia();
	
	
	private DepartamentoDTODomainAssembler() {
		super();
	}
	
	public static final DTODomainAssembler<DepartamentoDomain, DepartamentoDTO> obtenerInstancia(){
		return instancia;
	}
	
	@Override
	public final DepartamentoDomain ensamblarDominio(final DepartamentoDTO dto) {
		var departamentoDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new DepartamentoDTO());
		var paisDomain = paisAssembler.ensamblarDominio(departamentoDtoTmp.getPais());
		return DepartamentoDomain.crear(departamentoDtoTmp.getId(), departamentoDtoTmp.getNombre(), paisDomain);
	}

	@Override
	public final DepartamentoDTO ensamblarDTO(final DepartamentoDomain dominio) {
		var departamentoDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, DepartamentoDomain.crear());
		var paisDTO = paisAssembler.ensamblarDTO(departamentoDomainTmp.getPais());
		return DepartamentoDTO.build().setId(departamentoDomainTmp.getId()).setNombre(departamentoDomainTmp.getNombre()).setPais(paisDTO);
	}

	@Override
	public List<DepartamentoDTO> ensamblarListaDTO(List<DepartamentoDomain> listaDominios) {
		// TODO Auto-generated method stub
		return null;
	}

}
