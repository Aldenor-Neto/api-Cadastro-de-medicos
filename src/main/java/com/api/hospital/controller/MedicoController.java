package com.api.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.hospital.medico.DadosAtualizarMedico;
import com.api.hospital.medico.DadosCadastroMedico;
import com.api.hospital.medico.DadosListagemMedicos;
import com.api.hospital.medico.Medico;
import com.api.hospital.medico.MedicoRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/medico")

public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    // Método de listagem de Médicos
    /*
     * @GetMapping
     * public List<DadosListagemMedicos> listagem(){
     * return repository.findAll().stream().map(DadosListagemMedicos::new).toList();
     * }
     */

    // Método de paginação
    @GetMapping
    public Page<DadosListagemMedicos> listagem(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {

        // lista todos os ids do banco ativos e inativos
        // return repository.findAll(paginacao).map(DadosListagemMedicos::new);

        // Lista apenas os ativos do banco
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizarMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacao(dados);
    }

    // exclusão permanente
    /*
     * @DeleteMapping("/{id}")
     * 
     * @Transactional
     * public void excluirMedico(@PathVariable Long id) {
     * repository.deleteById(id);
     * }
     */

    // exclusão lógica
    @DeleteMapping("/{id}")
    @Transactional
    public void excluirMedico(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluirMedico();
    }
}