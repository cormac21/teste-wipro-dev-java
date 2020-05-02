package com.example.testewiprodevjava.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	
	private String codigo;
	
	private String descricao;
	
	private Double valorUnitario;
	
	private LocalDateTime dataDeCriacao;
	
	private Boolean ativo;
	
}
