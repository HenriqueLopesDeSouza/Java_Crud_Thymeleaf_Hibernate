package com.br.Cadastro_Lol.controller;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.Cadastro_Lol.Entity.Campeao;
import com.br.Cadastro_Lol.Entity.TipoCampeao;
import com.br.Cadastro_Lol.Helpers.GeneratePdfReport;
import com.br.Cadastro_Lol.Service.CampeaoService;


@Controller
public class CampeaoController {

	@Autowired
	private CampeaoService service;
	List<Campeao> list = new ArrayList<Campeao>();

	@GetMapping("/")
	public ModelAndView firstPage() {
		ModelAndView mv = new ModelAndView("/index");
		return mv;
	}

	@GetMapping("/listarCampeoes")   
	public ModelAndView listar() {        
		ModelAndView mv = new ModelAndView("/Campeoes");       
		list = service.buscarTodos();
		if( list != null && list.size() > 0 ) {
			mv.addObject("Campeao", list);
		}         
		return mv;
	}

	@ModelAttribute("allTypes") 
	public List<TipoCampeao> populateTypes() {
		List<TipoCampeao> list = service.buscarTodosTipos();
		return list;
	}


	@GetMapping("/IncluirCampeao")
	public ModelAndView incluir(Campeao campeao) {

		ModelAndView mv = new ModelAndView("/CampeoesAdd");	
		mv.addObject("Campeao", campeao);
		return mv;
	}

	@GetMapping("/alterarCampeao/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {

		return incluir(service.buscarPorId(id));
	}

	@GetMapping("/excluirCampeao/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {

		service.excluir(id);

		return listar();
	}

	@PostMapping("/gravarCampeao")
	public ModelAndView gravar(@Valid Campeao campeao, BindingResult result) {

		if(result.hasErrors()) {
			return incluir(campeao);
		}

		service.gravar(campeao);

		return listar();
	}

	@RequestMapping(value="/ListaTodos", method = RequestMethod.GET,produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getPDF(){

		ByteArrayInputStream bis = GeneratePdfReport.PDF(list);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=pessoas.pdf");

		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
}
