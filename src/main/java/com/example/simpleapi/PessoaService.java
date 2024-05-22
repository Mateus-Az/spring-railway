package com.example.simpleapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {


    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa obterPessoaPorId(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}
