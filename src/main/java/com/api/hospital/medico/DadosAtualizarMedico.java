package com.api.hospital.medico;

import com.api.hospital.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedico(
                @NotNull Long id,
                String nome,
                String Email,
                String telefone,
                Especialidade especialidade,
                DadosEndereco endereco) {

}
