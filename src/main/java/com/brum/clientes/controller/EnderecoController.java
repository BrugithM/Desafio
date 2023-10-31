package com.brum.clientes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brum.clientes.DTO.EnderecoDTO;
import com.brum.clientes.model.Endereco;
import com.brum.clientes.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }    

    @PostMapping
    public ResponseEntity<Object> cadastroEndereco(@RequestBody EnderecoDTO enderecoDTO){
        var endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.cadastroEndereco(endereco));
    }
    
    @GetMapping
    public ResponseEntity<List<Endereco>> listarEndereco(){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.listarEndereco());
    }

    @GetMapping("/{Id}")
        public ResponseEntity<Object> consultarEndereco(@PathVariable(value = "id")Integer Id){
        final Optional<Endereco> enderecoOptional = enderecoService.procurarEndereco(Id);
        if(!enderecoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(enderecoOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterarEndereco(@PathVariable(value = "id")Integer Id, @RequestBody EnderecoDTO enderecoDTO){
        Optional<Endereco> enderecoOptional = enderecoService.procurarEndereco(Id);
        if(!enderecoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado.");
        }
        var endereco = enderecoOptional.get();
        endereco.setCep(enderecoDTO.getCep());
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.cadastroEndereco(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirEndereco(@PathVariable(value = "id")Integer Id){
        final Optional<Endereco> enderecoOptional = enderecoService.procurarEndereco(Id);
        if(!enderecoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado.");
        }
        enderecoService.excluirEndereco(enderecoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Endereço apagado."); 
    }

}
