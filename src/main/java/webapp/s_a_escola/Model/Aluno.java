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
    private Double notaExatasB1;
    private Double notaExatasB2;
    private Double notaExatasB3;
    private Double notaExatasB4;
    private Double notaHumanasB1;
    private Double notaHumanasB2;
    private Double notaHumanasB3;
    private Double notaHumanasB4;
    private Double notaCienciasB1;
    private Double notaCienciasB2;
    private Double notaCienciasB3;
    private Double notaCienciasB4;
    private Double notaLinguagensB1;
    private Double notaLinguagensB2;
    private Double notaLinguagensB3;
    private Double notaLinguagensB4;
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

    public Double getNotaExatasB1() {
        return notaExatasB1;
    }

    public void setNotaExatasB1(Double notaExatasB1) {
        this.notaExatasB1 = notaExatasB1;
    }

    public Double getNotaExatasB2() {
        return notaExatasB2;
    }

    public void setNotaExatasB2(Double notaExatasB2) {
        this.notaExatasB2 = notaExatasB2;
    }

    public Double getNotaExatasB3() {
        return notaExatasB3;
    }

    public void setNotaExatasB3(Double notaExatasB3) {
        this.notaExatasB3 = notaExatasB3;
    }

    public Double getNotaExatasB4() {
        return notaExatasB4;
    }

    public void setNotaExatasB4(Double notaExatasB4) {
        this.notaExatasB4 = notaExatasB4;
    }

    public Double getNotaHumanasB1() {
        return notaHumanasB1;
    }

    public void setNotaHumanasB1(Double notaHumanasB1) {
        this.notaHumanasB1 = notaHumanasB1;
    }

    public Double getNotaHumanasB2() {
        return notaHumanasB2;
    }

    public void setNotaHumanasB2(Double notaHumanasB2) {
        this.notaHumanasB2 = notaHumanasB2;
    }

    public Double getNotaHumanasB3() {
        return notaHumanasB3;
    }

    public void setNotaHumanasB3(Double notaHumanasB3) {
        this.notaHumanasB3 = notaHumanasB3;
    }

    public Double getNotaHumanasB4() {
        return notaHumanasB4;
    }

    public void setNotaHumanasB4(Double notaHumanasB4) {
        this.notaHumanasB4 = notaHumanasB4;
    }

    public Double getNotaCienciasB1() {
        return notaCienciasB1;
    }

    public void setNotaCienciasB1(Double notaCienciasB1) {
        this.notaCienciasB1 = notaCienciasB1;
    }

    public Double getNotaCienciasB2() {
        return notaCienciasB2;
    }

    public void setNotaCienciasB2(Double notaCienciasB2) {
        this.notaCienciasB2 = notaCienciasB2;
    }

    public Double getNotaCienciasB3() {
        return notaCienciasB3;
    }

    public void setNotaCienciasB3(Double notaCienciasB3) {
        this.notaCienciasB3 = notaCienciasB3;
    }

    public Double getNotaCienciasB4() {
        return notaCienciasB4;
    }

    public void setNotaCienciasB4(Double notaCienciasB4) {
        this.notaCienciasB4 = notaCienciasB4;
    }

    public Double getNotaLinguagensB1() {
        return notaLinguagensB1;
    }

    public void setNotaLinguagensB1(Double notaLinguagensB1) {
        this.notaLinguagensB1 = notaLinguagensB1;
    }

    public Double getNotaLinguagensB2() {
        return notaLinguagensB2;
    }

    public void setNotaLinguagensB2(Double notaLinguagensB2) {
        this.notaLinguagensB2 = notaLinguagensB2;
    }

    public Double getNotaLinguagensB3() {
        return notaLinguagensB3;
    }

    public void setNotaLinguagensB3(Double notaLinguagensB3) {
        this.notaLinguagensB3 = notaLinguagensB3;
    }

    public Double getNotaLinguagensB4() {
        return notaLinguagensB4;
    }

    public void setNotaLinguagensB4(Double notaLinguagensB4) {
        this.notaLinguagensB4 = notaLinguagensB4;
    }

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
}
