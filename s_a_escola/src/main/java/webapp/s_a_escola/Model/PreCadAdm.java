package webapp.s_a_escola.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PreCadAdm {
    @Id
    private String cpf;
    private String nome;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
