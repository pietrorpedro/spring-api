package med.voll.api.entities;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.models.Endereco;
import med.voll.api.models.Especialidade;
import med.voll.api.models.Medico;

@Entity(name = "Medico")
@Table(name = "medicos")

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
public class MedicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome, email, crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private EnderecoEntity endereco;

    public MedicoEntity(Medico dadosMedico) {
        this.nome = dadosMedico.nome();
        this.email = dadosMedico.email();
        this.crm = dadosMedico.crm();
        this.especialidade = dadosMedico.especialidade();
        this.endereco = new EnderecoEntity(dadosMedico.endereco());
    }
}
