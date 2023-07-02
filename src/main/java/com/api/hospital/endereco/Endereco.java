package com.api.hospital.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Endereco {

    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.rua = dados.rua();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }

    public void atualizarEndereco(Endereco dados) {
        if (dados.getRua() != null) {
            this.rua = dados.getRua();
        }

        if (dados.getNumero() != null) {
            this.numero = dados.getNumero();
        }

        if (dados.getComplemento() != null) {
            this.complemento = dados.getComplemento();
        }

        if (dados.getBairro() != null) {
            this.bairro = dados.getBairro();
        }

        if (dados.getCidade() != null) {
            this.cidade = dados.getCidade();
        }

        if (dados.getUf() != null) {
            this.uf = dados.getUf();
        }

    }
}
