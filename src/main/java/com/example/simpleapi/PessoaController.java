package com.example.simpleapi;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@Valid @RequestBody Pessoa pessoa) {
        Pessoa novaPessoa = pessoaService.salvarPessoa(pessoa);
        return ResponseEntity.ok(novaPessoa);
    }

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> obterPessoaPorId(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.obterPessoaPorId(id);
        if (pessoa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.obterPessoaPorId(id);
        if (pessoa == null) {
            return ResponseEntity.notFound().build();
        }
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }
}
