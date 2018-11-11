package com.br.Cadastro_Lol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.Cadastro_Lol.Entity.Campeao;
import com.br.Cadastro_Lol.Service.CampeaoService;

@RestController
public class CampeaoRestController {
	
	@Autowired
	private CampeaoService service;
	
	@RequestMapping(value="/showJSON", method=RequestMethod.GET)
	public ResponseEntity<List<Campeao>> listar() {
		return new ResponseEntity<List<Campeao>>( service.buscarTodos(), HttpStatus.OK );
    } 

}
