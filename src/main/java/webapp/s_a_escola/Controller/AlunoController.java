package webapp.s_a_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webapp.s_a_escola.Model.Aluno;
import webapp.s_a_escola.Repository.AlunoRepository;

@Controller
public class AlunoController {

    boolean acessoAluno = false;

    @Autowired
    AlunoRepository alr;

    @PostMapping("/cadastrar-aluno")
    public String cadastrarAlunoBD(Aluno al,
                                   @RequestParam(required = false) boolean materiaExatas,
                                   @RequestParam(required = false) boolean materiaHumanas,
                                   @RequestParam(required = false) boolean materiaCiencias,
                                   @RequestParam(required = false) boolean materiaLinguagens) {
        al.setMateriaExatas(materiaExatas);
        al.setMateriaHumanas(materiaHumanas);
        al.setMateriaCiencias(materiaCiencias);
        al.setMateriaLinguagens(materiaLinguagens);

        String ra = "2024" + String.valueOf(alr.findByIdList().size());
        al.setRa(ra);
        al.setSenha(ra);

        alr.save(al);
        System.out.println("Cadastro Realizado com Sucesso");
        return "interna/interna-adm";
    }

    @GetMapping("/interna-aluno")
    public String acessoPageInternaAluno(@RequestParam String ra, Model model) {
        String vaiPara = "";
        if (acessoAluno) {
            vaiPara = "interna/interna-aluno";
        } else {
            vaiPara = "login/login-aluno";
        }
        Aluno aluno = alr.findByRa(ra);
        model.addAttribute("aluno", aluno);
        return vaiPara;
    }

    @PostMapping("acesso-aluno")
    public String acessoAluno(@RequestParam String ra,
            @RequestParam String senha) {
        try {
            boolean verificaRa = alr.existsByRa(ra);
            boolean verificaSenha = alr.findByRa(ra).getSenha().equals(senha);
            String url = "";
            if (verificaRa && verificaSenha) {
                acessoAluno = true;
                url = "redirect:interna-aluno?ra=" + ra;
            } else {
                url = "redirect:/login-aluno";
                System.out.println("Erro de login");
            }
            return url;
        } catch (Exception e) {
            System.out.println("Erro de login");
            return "redirect:/login-aluno";
        }
    }

    @PostMapping("/pesquisa-aluno")
    public String pesquisaAlunoPorNome(@RequestParam String nome, Model model) {
        Iterable<Aluno> alunos = alr.findByNomeContaining(nome);
        model.addAttribute("alunos", alunos);
        return "interna/interna-adm";
    }

    @GetMapping("/minhas-notas")
    public String exibirNotas(Model model, @RequestParam String ra) {
        Aluno aluno = alr.findByRa(ra);
        model.addAttribute("aluno", aluno);
        return "pagina_notas";
    }

}
