package com.brum.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brum.clientes.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato,Integer>{
    
}
