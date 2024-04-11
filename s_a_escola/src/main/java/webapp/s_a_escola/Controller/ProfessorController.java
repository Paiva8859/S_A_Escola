package webapp.s_a_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import webapp.s_a_escola.Model.Professor;
import webapp.s_a_escola.Repository.ProfessorRepository;

@Controller
public class ProfessorController {

    @Autowired
    ProfessorRepository pr;

    @PostMapping("cadastrar-professor")
    public String cadastrarProBD(Professor pro) {
        pr.save(pro);
        System.out.println("Cadastro Realizado com Sucesso");
        return "/interna/interna-professor";
    }
}
