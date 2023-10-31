package com.brum.clientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.brum.clientes.ViaCepResponse;
import com.brum.clientes.model.Endereco;
import com.brum.clientes.repository.EnderecoRepository;

@Service
public class EnderecoService {
    EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    RestTemplate restTemplate = new RestTemplate();

    public Endereco cadastroEndereco(Endereco endereco){
        String viaCepUrl = "https://viacep.com.br/ws/"+ endereco.getCep() + "/json/";
        ViaCepResponse viaCepResponse = restTemplate.getForObject(viaCepUrl, ViaCepResponse.class);
        if(viaCepResponse !=null){
            endereco.setLogradouro(viaCepResponse.getLogradouro());
            endereco.setCidade(viaCepResponse.getLocalidade());
        }
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarEndereco(){
        return enderecoRepository.findAll();
    }
    
    public Optional<Endereco> procurarEndereco(Integer Id){
        return enderecoRepository.findById(Id);
    }

    
    public void excluirEndereco(Endereco endereco){
        enderecoRepository.delete(endereco);
    }


}
