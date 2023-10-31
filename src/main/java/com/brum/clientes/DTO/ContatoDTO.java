package com.brum.clientes.DTO;


public class ContatoDTO {
    private String Tipo;
    private String Texto;

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
