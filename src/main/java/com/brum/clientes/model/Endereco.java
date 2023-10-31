package com.brum.clientes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Endereco extends Cliente{
    @Column(unique = false, length = 8)
    private String Cep;
    @Column(unique = false, length = 100)
    private String Logradouro;
    @Column(unique = false, length = 100)
    private String Cidade;
    @Column(unique = false, length = 100)
    private String Numero;
    @Column(unique = false, length = 100)
    private String Complemento;

    
    public void setCep(String Cep){
        this.Cep=Cep;
    }
    public String getCep(){
        return Cep;
    }

    public void setLogradouro(String Logradouro){
        this.Logradouro=Logradouro;
    }
    public String getLogradouro(){
        return Logradouro;
    }

    public void setCidade(String Cidade){
        this.Cidade=Cidade;
    }
    public String getCidade(){
        return Cidade;
    }
    
    public void setNumero(String Numero){
        this.Numero=Numero;
    }
    public String getNumero(){
        return Numero;
    }
    
    public void setComplemento(String Complemento){
        this.Complemento=Complemento;
    }
    public String getComplemento(){
        return Complemento;
    }

    
}
