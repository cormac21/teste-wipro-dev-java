package com.example.testewiprodevjava.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.testewiprodevjava.model.Produto;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long>{
	
	Page<Produto> findByAtivoTrue( Pageable pageable );
	
	Page<Produto> findByAtivoFalse( Pageable pageable );

}
