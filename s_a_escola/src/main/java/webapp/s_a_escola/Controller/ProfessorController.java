package webapp.s_a_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webapp.s_a_escola.Model.Aluno;
import webapp.s_a_escola.Model.Professor;
import webapp.s_a_escola.Repository.AlunoRepository;
import webapp.s_a_escola.Repository.ProfessorRepository;

@Controller
public class ProfessorController {

    @Autowired
    ProfessorRepository pr;

    boolean acessoProfessor = false;

    @Autowired
    AlunoRepository alr;

    @PostMapping("cadastrar-professor")
    public String cadastrarAlunoBD(Professor pro,
            @RequestParam(required = false) boolean materiaExatas,
            @RequestParam(required = false) boolean materiaHumanas,
            @RequestParam(required = false) boolean materiaCiencias,
            @RequestParam(required = false) boolean materiaLinguagens) {
        pro.setMateriaExatas(materiaExatas);
        pro.setMateriaHumanas(materiaHumanas);
        pro.setMateriaCiencias(materiaCiencias);
        pro.setMateriaLinguagens(materiaLinguagens);
        pr.save(pro);
        System.out.println("Cadastro Realizado com Sucesso");
        return "/interna/interna-adm";
    }

    @PostMapping("acesso-professor")
    public String acessoProfessor(@RequestParam String cpf,
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

    @PostMapping("/atribuir-notas-exatas")
    public String atribuirNotasExatas(@RequestParam String ra,
            @RequestParam double notaExatasB1,
            @RequestParam double notaExatasB2,
            @RequestParam double notaExatasB3,
            @RequestParam double notaExatasB4) {
        Aluno aluno = alr.findByRa(ra);
        if (aluno != null) {
            aluno.setNotaExatasB1(notaExatasB1);
            aluno.setNotaExatasB2(notaExatasB2);
            aluno.setNotaExatasB3(notaExatasB3);
            aluno.setNotaExatasB4(notaExatasB4);
            alr.save(aluno);
            return "redirect:/interna-professor";
        } else {
            return "redirect:/interna-professor?error=Aluno não encontrado";
        }
    }

    @PostMapping("/atribuir-notas-humanas")
    public String atribuirNotasHumanas(@RequestParam String ra,
            @RequestParam double notaHumanasB1,
            @RequestParam double notaHumanasB2,
            @RequestParam double notaHumanasB3,
            @RequestParam double notaHumanasB4) {
        Aluno aluno = alr.findByRa(ra);
        if (aluno != null) {
            aluno.setNotaHumanasB1(notaHumanasB1);
            aluno.setNotaHumanasB2(notaHumanasB2);
            aluno.setNotaHumanasB3(notaHumanasB3);
            aluno.setNotaHumanasB4(notaHumanasB4);
            alr.save(aluno);
            return "redirect:/interna-professor";
        } else {
            return "redirect:/interna-professor?error=Aluno não encontrado";
        }
    }

    @PostMapping("/atribuir-notas-ciencias")
    public String atribuirNotasCiencias(@RequestParam String ra,
            @RequestParam double notaCienciasB1,
            @RequestParam double notaCienciasB2,
            @RequestParam double notaCienciasB3,
            @RequestParam double notaCienciasB4) {
        Aluno aluno = alr.findByRa(ra);
        if (aluno != null) {
            aluno.setNotaCienciasB1(notaCienciasB1);
            aluno.setNotaCienciasB2(notaCienciasB2);
            aluno.setNotaCienciasB3(notaCienciasB3);
            aluno.setNotaCienciasB4(notaCienciasB4);
            alr.save(aluno);
            return "redirect:/interna-professor";
        } else {
            return "redirect:/interna-professor?error=Aluno não encontrado";
        }
    }

    @PostMapping("/atribuir-notas-linguagens")
    public String atribuirNotasLinguagens(@RequestParam String ra,
            @RequestParam double notaLinguagensB1,
            @RequestParam double notaLinguagensB2,
            @RequestParam double notaLinguagensB3,
            @RequestParam double notaLinguagensB4) {
        Aluno aluno = alr.findByRa(ra);
        if (aluno != null) {
            aluno.setNotaLinguagensB1(notaLinguagensB1);
            aluno.setNotaLinguagensB2(notaLinguagensB2);
            aluno.setNotaLinguagensB3(notaLinguagensB3);
            aluno.setNotaLinguagensB4(notaLinguagensB4);
            alr.save(aluno);
            return "redirect:/interna-professor";
        } else {
            return "redirect:/interna-professor?error=Aluno não encontrado";
        }
    }
}
