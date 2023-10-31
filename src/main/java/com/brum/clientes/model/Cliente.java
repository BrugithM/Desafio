package com.brum.clientes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column(unique = false, length = 100)
    private String Nome;
    @Column(unique = false, length = 10)
    private String DataCadastro;
    
    public void setId(int Id){
        this.Id=Id;
    }
    
    public int getId(){
        return Id;
    }
    
    public void setNome(String Nome){
        this.Nome = Nome;
    }
        
    public String getNome(){
        return Nome;
    }
    
    public void setDataCadastro(String DataCadastro){
        this.DataCadastro = DataCadastro;
    }

    public String getDataCadastro(){
        return DataCadastro;
    }
}
