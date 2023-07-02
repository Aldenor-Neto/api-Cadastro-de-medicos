package com.api.hospital.medico;

import com.api.hospital.endereco.DadosEndereco;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroMedico(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String telefone, @NotBlank String crm, @NotBlank Especialidade especialidade, DadosEndereco endereco) {
    
}
