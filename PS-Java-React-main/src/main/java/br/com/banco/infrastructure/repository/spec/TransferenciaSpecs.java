package br.com.banco.infrastructure.repository.spec;

import java.util.ArrayList;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import br.com.banco.domain.filter.TransferenciaFilter;
import br.com.banco.domain.model.Transferencia;

public class TransferenciaSpecs {

	public static Specification<Transferencia> usandoFiltro(TransferenciaFilter filter){
		return (root, query, builder) -> {
			var predicates = new ArrayList<Predicate>();
			
			if(Transferencia.class.equals(query.getResultType())) {
				root.fetch("conta");
			}
			
			if(filter.getContaId() != null) {
				predicates.add(builder.equal(root.get("conta"), filter.getContaId()));
			}
				
			if(filter.getDataCriacaoInicio() != null) {
				predicates.add(builder.greaterThanOrEqualTo(root.get("dataTransferencia"), filter.getDataCriacaoInicio()));
			}
			
			if(filter.getDataCriacaoFim() != null) {
				predicates.add(builder.lessThanOrEqualTo(root.get("dataTransferencia"), filter.getDataCriacaoFim()));
			}
			
			if(filter.getNomeOperador() != null && !filter.getNomeOperador().equals("")) {
				predicates.add(builder.equal(root.get("nomeOperador"), filter.getNomeOperador()));
			}
			
			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
