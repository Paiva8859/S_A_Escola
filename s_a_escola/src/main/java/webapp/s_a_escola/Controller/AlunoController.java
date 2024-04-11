package webapp.s_a_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @PostMapping("cadastrar-aluno")
    public String cadastrarAlunoBD(Aluno al) {
        alr.save(al);
        al.setRa("2024"+String.valueOf(alr.findByIdList().size()));
        al.setSenha("2024"+String.valueOf(alr.findByIdList().size()));

        alr.save(al);
        System.out.println("Cadastro Realizado com Sucesso");
        return "/interna/interna-aluno";
    }

    @GetMapping("/interna-aluno")
    public String acessoPageInternaAluno() {
        String vaiPara = "";
        if (acessoAluno) {
            vaiPara = "interna/interna-aluno";
        } else {
            vaiPara = "login/login-aluno";
        }
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
                url = "redirect:interna-aluno";
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
}
