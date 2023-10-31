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

import com.brum.clientes.DTO.ClienteDTO;
import com.brum.clientes.model.Cliente;
import com.brum.clientes.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService=clienteService;
    }

    @PostMapping
    public ResponseEntity<Object> cadastroCliente(@RequestBody ClienteDTO clienteDTO){
        var cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.cadastroCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.listarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> consultarCliente(@PathVariable(value = "id")Integer Id){
        final Optional<Cliente> clienteOptional = clienteService.procurarCliente(Id);
        if(!clienteOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterarCliente(@PathVariable(value = "id")Integer Id, @RequestBody ClienteDTO clienteDTO){
        Optional<Cliente> clienteOptional = clienteService.procurarCliente(Id);
        if(!clienteOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        var cliente = clienteOptional.get();
        cliente.setNome(clienteDTO.getNome());
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.cadastroCliente(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirCliente(@PathVariable(value = "id")Integer Id){
        final Optional<Cliente> clienteOptional = clienteService.procurarCliente(Id);
        if(!clienteOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        clienteService.excluirCliente(clienteOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente apagado."); 
    }
}
