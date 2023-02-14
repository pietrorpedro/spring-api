package med.voll.api.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.models.Endereco;

@Embeddable

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntity {
    private String logradouro, bairro, cep, numero, complemento, cidade, uf;

    public EnderecoEntity(Endereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.complemento = dados.complemento();
        this.numero = dados.numero();
    }
}
