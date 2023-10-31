package com.brum.clientes.model;

import javax.persistence.JoinColumn;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Contato extends Cliente{
    
    @Id
    @JoinColumn(name="id")
    private int Id;
    @Column(unique=false, length = 50)
    private String Tipo;
    @Column(unique=false, length = 50)
    private String Texto;

    public int getId(){
        return Id;
    }

    public void setTipo(String Tipo){
        this.Tipo=Tipo;
    }
    public String getTipo(){
        return Tipo;
    }

    public void setTexto(String Texto){
        this.Texto=Texto;
    }
    public String getTexto(){
        return Texto;
    }

}
