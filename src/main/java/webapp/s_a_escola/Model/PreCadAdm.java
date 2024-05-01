package webapp.s_a_escola.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PreCadAdm {
    @Id
    private String cpf;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
