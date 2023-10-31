package com.brum.clientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brum.clientes.model.Cliente;
import com.brum.clientes.repository.ClienteRepository;

@Service
public class ClienteService {
    ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastroCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
    
    public Optional<Cliente> procurarCliente(Integer Id){
        return clienteRepository.findById(Id);
    }

    public void excluirCliente(Cliente cliente){
        clienteRepository.delete(cliente);
    }
}
