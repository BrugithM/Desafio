package com.brum.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brum.clientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
