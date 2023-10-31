package com.brum.clientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brum.clientes.model.Contato;
import com.brum.clientes.repository.ContatoRepository;

@Service
public class ContatoService {
    ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public Contato cadastroContato(Contato contato){
        return contatoRepository.save(contato);
    }

    public List<Contato> listarContato(){
        return contatoRepository.findAll();
    }
    
    public Optional<Contato> procurarContato(Integer Id){
        return contatoRepository.findById(Id);
    }
    
    public void excluirContato(Contato contato){
        contatoRepository.delete(contato);
    }

}
