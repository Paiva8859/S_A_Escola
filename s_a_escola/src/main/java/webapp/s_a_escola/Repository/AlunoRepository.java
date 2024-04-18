package webapp.s_a_escola.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import webapp.s_a_escola.Model.Aluno;

import java.util.List;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    @Query("SELECT a FROM Aluno a")
    List<Aluno> findByIdList();

    // Método para buscar aluno pelo RA
    Aluno findByRa(String ra);
    boolean existsByRa(String ra);

    // Método para buscar alunos pelo nome (contendo uma parte do nome)
    List<Aluno> findByNomeContaining(String nome);
}

