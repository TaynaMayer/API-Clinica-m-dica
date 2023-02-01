package med.voll.api.medico;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.endereco.Endereco;

@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medicos")
@Entity(name= "Medico")
public class Medico {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_medico", columnDefinition = "uuid")
  private UUID id;

  private String nome;

  private String email;

  private String telefone;

  private String crm; 

  @Embedded
  private Endereco endereco;

  private Boolean ativo;

  @Enumerated(EnumType.STRING)
  private Especialidade especialidade;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();   
        this.telefone = dados.telefone();    
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoMedico dados) {
      if (dados.nome() != null) {
        this.nome = dados.nome();
    }
    if (dados.telefone() != null) {
        this.telefone = dados.telefone();
    }
    if (dados.endereco() != null) {
        this.endereco.atualizarInformacoes(dados.endereco());
    }

}

    public void excluir() {
      this.ativo = false;
    }

}  