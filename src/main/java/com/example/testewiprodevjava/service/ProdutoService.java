package com.example.testewiprodevjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.testewiprodevjava.model.Produto;
import com.example.testewiprodevjava.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produRepo;

	public Page<Produto> findAll(Pageable pagina) {
		return produRepo.findAll(pagina);
	}

	public Page<Produto> findAllByAtivo(Boolean ativo, Pageable pagina) {
		if( ativo.booleanValue() ) {
			return produRepo.findByAtivoTrue(pagina);
		} else {
			return produRepo.findByAtivoFalse(pagina);
		}
	}

	public Produto inserirProduto(Produto produto) {
		return produRepo.save(produto);
	}

}
