package br.com.banco.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.domain.filter.TransferenciaFilter;
import br.com.banco.domain.model.Transferencia;
import br.com.banco.domain.repository.TransferenciaRepository;
import br.com.banco.infrastructure.repository.spec.TransferenciaSpecs;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	public List<Transferencia> obterTransferencias(TransferenciaFilter filter) {
		return transferenciaRepository
				.findAll(TransferenciaSpecs.usandoFiltro(filter));
	}
}
