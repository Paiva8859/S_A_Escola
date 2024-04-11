package webapp.s_a_escola.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import webapp.s_a_escola.Model.Aluno;
import java.util.List;


public interface AlunoRepository extends CrudRepository<Aluno, Long>{
    @Query(
        "SELECT a FROM Aluno a"
    )
    List<Aluno> findByIdList();

    //@Query("SELECT * FROM aluno WHERE ra = ?")
    Aluno findByRa(String ra);
    boolean existsByRa(String ra);
}
