package co.edu.uco.tiendachepito.business.assembler.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.tiendachepito.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.entity.PaisEntity;

public class PaisEntityDomainAssembler implements EntityDomainAssembler<PaisDomain, PaisEntity>{
	
	private static final EntityDomainAssembler<PaisDomain, PaisEntity> instancia = new PaisEntityDomainAssembler();
	
	private PaisEntityDomainAssembler() {
		super();
	}
	
	public static final EntityDomainAssembler<PaisDomain, PaisEntity> obtenerInstancia() {
		return instancia;
	}
	
	
	@Override
	public final PaisDomain ensamblarDominio(final PaisEntity entidad) {
		var paisEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, PaisEntity.build(0));
		return PaisDomain.crear(paisEntityTmp.getId(),paisEntityTmp.getNombre());
	}

	@Override
	public final PaisEntity ensablarEntidad(final PaisDomain dominio) {
		var paisDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, PaisDomain.crear());
		return PaisEntity.build(paisDomainTmp.getId(), paisDomainTmp.getNombre());
	}

	@Override
	public final List<PaisDomain> ensamblarListaDominios(final List<PaisEntity> listaEntidades) {
		var listaEntidadesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<PaisEntity>());
		var resultados = new ArrayList<PaisDomain>();
		
		for (PaisEntity paisEntity : listaEntidadesTmp) {
			var paisDomainTmp = ensamblarDominio(paisEntity);
			resultados.add(paisDomainTmp);
		}
		
		return resultados;
	}
	

}
