package med.voll.api.medico;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        UUID id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
