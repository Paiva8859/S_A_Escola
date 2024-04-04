package webapp.s_a_escola.Repository;

import org.springframework.data.repository.CrudRepository;
import webapp.s_a_escola.Model.Administrador;

public interface AdministradorRepository extends CrudRepository<Administrador, String>{
    Administrador findByCpf(String cpf);
}
