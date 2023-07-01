package com.api.hospital.endereco;

import jakarta.validation.constraints.NotBlank;

public record DadosEndereco(@NotBlank String rua, @NotBlank String numero, String complemento, @NotBlank String bairro, @NotBlank String cidade, @NotBlank String uf) {
    
}
