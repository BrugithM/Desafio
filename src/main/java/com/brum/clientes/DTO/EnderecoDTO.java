package com.brum.clientes.DTO;

public class EnderecoDTO {
    private String Cep;
    private String Logradouro;
    private String Cidade;
    private String Numero;
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
