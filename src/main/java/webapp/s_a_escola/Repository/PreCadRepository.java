package webapp.s_a_escola.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.s_a_escola.Model.PreCadAdm;

public interface PreCadRepository extends CrudRepository<PreCadAdm, String>{
    PreCadAdm findByCpf (String cpf);
}
