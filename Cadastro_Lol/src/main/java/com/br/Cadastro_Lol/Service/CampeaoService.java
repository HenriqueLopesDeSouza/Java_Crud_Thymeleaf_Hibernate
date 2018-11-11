package com.br.Cadastro_Lol.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.Cadastro_Lol.Entity.Campeao;
import com.br.Cadastro_Lol.Entity.TipoCampeao;
import com.br.Cadastro_Lol.Repository.CampeaoRepository;
import com.br.Cadastro_Lol.Repository.TipoCampeaoRepository;

@Service
public class CampeaoService {
	
	@Autowired
	private CampeaoRepository CampeaoRepository;
	
	@Autowired
	private TipoCampeaoRepository TipoCampeaoRepository;
	
	public List<Campeao> buscarTodos() {
        return CampeaoRepository.findAll();
    }
	
	public List<TipoCampeao> buscarTodosTipos() {
        return TipoCampeaoRepository.findAll();
    }
     
    public Campeao buscarPorId(Long id) {
    	return CampeaoRepository.getOne(id);
    }
     
    public Campeao gravar(Campeao carro) {
        return CampeaoRepository.saveAndFlush(carro);
    }
     
    public void excluir(Long id) {
    	CampeaoRepository.deleteById( id );
    }   

}
