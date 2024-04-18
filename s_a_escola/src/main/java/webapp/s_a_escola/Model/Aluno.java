package webapp.s_a_escola.Model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aluno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ra;
    private String nome;
    private String email;
    private String senha;
    private Double notaB1;
    private Double notaB2;
    private Double notaB3;
    private Double notaB4;

    public Long getId() {
        return id;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
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

    public Double getNotaB1() {
        return notaB1;
    }

    public void setNotaB1(Double notaB1) {
        this.notaB1 = notaB1;
    }

    public Double getNotaB2() {
        return notaB2;
    }

    public void setNotaB2(Double notaB2) {
        this.notaB2 = notaB2;
    }

    public Double getNotaB3() {
        return notaB3;
    }

    public void setNotaB3(Double notaB3) {
        this.notaB3 = notaB3;
    }

    public Double getNotaB4() {
        return notaB4;
    }

    public void setNotaB4(Double notaB4) {
        this.notaB4 = notaB4;
    }
}
