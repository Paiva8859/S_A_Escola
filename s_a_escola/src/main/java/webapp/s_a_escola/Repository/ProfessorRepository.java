package webapp.s_a_escola.Repository;

import org.springframework.data.repository.CrudRepository;
import webapp.s_a_escola.Model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, String>{
    Professor findByCpf(String cpf);

    boolean existsByCpf(String cpf);
}
