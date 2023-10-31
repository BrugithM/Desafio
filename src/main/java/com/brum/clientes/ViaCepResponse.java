package com.brum.clientes;

public class ViaCepResponse {
    private String logradouro;
    private String localidade;

    
    public void setLogradouro(String logradouro){
        this.logradouro=logradouro;
    }
    public String getLogradouro(){
        return logradouro;
    }

    public void setLocalidade(String localidade){
        this.localidade=localidade;
    }
    public String getLocalidade(){
        return localidade;
    }


}
