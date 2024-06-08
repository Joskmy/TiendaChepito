package co.edu.uco.tiendachepito.business.assembler.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.tiendachepito.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.dto.PaisDTO;

public class PaisDTODomainAssembler implements DTODomainAssembler<PaisDomain, PaisDTO> {
	
	
	private static final DTODomainAssembler<PaisDomain, PaisDTO> instancia = new PaisDTODomainAssembler();
	
	private PaisDTODomainAssembler() {
		super();
	}
	
	public static final DTODomainAssembler<PaisDomain, PaisDTO> obtenerInstancia(){
		return instancia;
	}
	
	@Override
	public final PaisDomain ensamblarDominio(final PaisDTO dto) {
		var paisDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new PaisDTO());
		return PaisDomain.crear(paisDtoTmp.getId(), paisDtoTmp.getNombre());
	}

	@Override
	public final PaisDTO ensamblarDTO(final PaisDomain dominio) {
		var paisDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, PaisDomain.crear());
		return PaisDTO.build().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());
	}

	@Override
	public final List<PaisDTO> ensamblarListaDTO(final List<PaisDomain> listaDominios) {
		var listaDominiosTmp = ObjectHelper.getObjectHelper().getDefault(listaDominios, new ArrayList<PaisDomain>());
		var resultados = new ArrayList<PaisDTO>();
		
		for (PaisDomain paisDomain : listaDominiosTmp) {
			var paisDtoTmp = ensamblarDTO(paisDomain);
			
			resultados.add(paisDtoTmp);
		}
		
		return resultados;
	}

}
