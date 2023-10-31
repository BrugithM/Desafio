package com.brum.clientes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brum.clientes.DTO.ContatoDTO;
import com.brum.clientes.model.Contato;
import com.brum.clientes.service.ContatoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contato")
public class ContatoController {
    ContatoService contatoService;

    public ContatoController(ContatoService contatoService){
        this.contatoService=contatoService;
    }

    @PostMapping
    public ResponseEntity<Object> cadastroContato(@RequestBody ContatoDTO contatoDTO){
        var contato = new Contato();
        BeanUtils.copyProperties(contatoDTO, contato);
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.cadastroContato(contato));
    }

    @GetMapping
    public ResponseEntity<List<Contato>> listarContato(){
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.listarContato());
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Object> consultarContato(@PathVariable(value = "id")Integer Id){
        Optional <Contato> contatoOptional = contatoService.procurarContato(Id);
        if(!contatoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(contatoOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterarContato(@PathVariable(value = "id")Integer Id, @RequestBody ContatoDTO contatoDTO){
        Optional<Contato> contatoOptional = contatoService.procurarContato(Id);
        if(!contatoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado.");
        }
        var contato = contatoOptional.get();
        contato.setTipo(contatoDTO.getTipo());
        contato.setTexto(contatoDTO.getTexto());
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.cadastroContato(contato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirContato(@PathVariable(value = "id")Integer Id){
        final Optional<Contato> contatoOptional = contatoService.procurarContato(Id);
        if(!contatoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado.");
        }
        contatoService.excluirContato(contatoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Contato apagado."); 
    }

    
}
