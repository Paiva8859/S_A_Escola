package webapp.s_a_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webapp.s_a_escola.Model.Aluno;
import webapp.s_a_escola.Repository.AlunoRepository;
import webapp.s_a_escola.Model.Professor;
import webapp.s_a_escola.Repository.ProfessorRepository;

@Controller
public class ProfessorController {

    @Autowired
    ProfessorRepository pr;

    boolean acessoProfessor = false;

    @Autowired
    AlunoRepository alr;

    @PostMapping("acesso-professor")
    public String acessoAluno(@RequestParam String cpf,
            @RequestParam String senha) {
        try {
            boolean verificaCpf = pr.existsByCpf(cpf);
            boolean verificaSenha = pr.findByCpf(cpf).getSenha().equals(senha);
            String url = "";
            if (verificaCpf && verificaSenha) {
                acessoProfessor = true;
                url = "redirect:interna-professor";
            } else {
                url = "redirect:/login-professor";
                System.out.println("Erro de login");
            }
            return url;
        } catch (Exception e) { 
            System.out.println("Erro de login");
            return "redirect:/login-professor";
        }
    }

    @GetMapping("/interna-professor")
    public String acessoPageInternaProfessor() {
        return "interna/interna-professor";
    }

    @PostMapping("/pesquisar-aluno")
    public String pesquisarAluno(@RequestParam String nome, Model model) {
        Iterable<Aluno> alunos = alr.findByNomeContaining(nome);
        model.addAttribute("alunos", alunos);
        return "interna/interna-professor";
    }

    @PostMapping("/atribuir-notas")
    public String atribuirNotas(@RequestParam String ra,
                                @RequestParam double notaB1,
                                @RequestParam double notaB2,
                                @RequestParam double notaB3,
                                @RequestParam double notaB4) {
        Aluno aluno = alr.findByRa(ra);
        if (aluno != null) {
            aluno.setNotaB1(notaB1);
            aluno.setNotaB2(notaB2);
            aluno.setNotaB3(notaB3);
            aluno.setNotaB4(notaB4);
            alr.save(aluno);
        }
        return "redirect:/interna-professor";
    }
}
