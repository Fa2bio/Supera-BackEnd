package br.com.banco.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.api.assembler.TransferenciaModelAssembler;
import br.com.banco.api.model.TransferenciaModel;
import br.com.banco.domain.filter.TransferenciaFilter;
import br.com.banco.domain.service.TransferenciaService;

@RestController
@RequestMapping(value = "/transferencias")
public class TransferenciaController {

	@Autowired
	private TransferenciaService transferenciaService;
	
	@Autowired
	private TransferenciaModelAssembler transferenciaModelAssembler;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public CollectionModel<TransferenciaModel> pesquisar(TransferenciaFilter filter){
		return transferenciaModelAssembler
				.toCollectionModel(transferenciaService.obterTransferencias(filter));
		 
	}

}
