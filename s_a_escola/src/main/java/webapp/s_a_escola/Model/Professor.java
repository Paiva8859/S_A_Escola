package webapp.s_a_escola.Model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Professor implements Serializable{
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private boolean materiaExatas;
    private boolean materiaHumanas;
    private boolean materiaCiencias;
    private boolean materiaLinguagens;

    public boolean isMateriaExatas() {
        return materiaExatas;
    }
    public void setMateriaExatas(boolean materiaExatas) {
        this.materiaExatas = materiaExatas;
    }
    public boolean isMateriaHumanas() {
        return materiaHumanas;
    }
    public void setMateriaHumanas(boolean materiaHumanas) {
        this.materiaHumanas = materiaHumanas;
    }
    public boolean isMateriaCiencias() {
        return materiaCiencias;
    }
    public void setMateriaCiencias(boolean materiaCiencias) {
        this.materiaCiencias = materiaCiencias;
    }
    public boolean isMateriaLinguagens() {
        return materiaLinguagens;
    }
    public void setMateriaLinguagens(boolean materiaLinguagens) {
        this.materiaLinguagens = materiaLinguagens;
    }

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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
