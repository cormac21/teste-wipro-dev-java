package com.example.testewiprodevjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.testewiprodevjava.model.Produto;
import com.example.testewiprodevjava.service.ProdutoService;

@RestController
public class ProdutoController {
	
	@Autowired
	ProdutoService produService;
	
	@RequestMapping(path = "/produtos", method = RequestMethod.GET)
	public ResponseEntity<?> findAllProdutos( @RequestParam Boolean ativo, 
			@RequestParam Integer numeroPagina, @RequestParam Integer tamanho) {
		Pageable pagina = PageRequest.of(numeroPagina, tamanho);
		Page<Produto> produtos = produService.findAllByAtivo(ativo, pagina);
		return ResponseEntity.ok(produtos);
	}
	
	@RequestMapping(path = "/produtos", method = RequestMethod.POST)
	public ResponseEntity<?> inserirProduto( @RequestBody Produto produto ) {
		Produto produtoInserido = produService.inserirProduto(produto);
		return ResponseEntity.ok(produtoInserido);
	}
	
	

}
