package webapp.s_a_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import webapp.s_a_escola.Model.Administrador;
import webapp.s_a_escola.Repository.AdministradorRepository;
import webapp.s_a_escola.Repository.PreCadRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdministradorController {

    @Autowired
    AdministradorRepository ar;

    @Autowired
    PreCadRepository vcar;

    boolean acessoAdm = false;

    @PostMapping("cadastrar-adm")
    public String cadastrarAdmBD(Administrador adm) {
        boolean verificaCpf = vcar.existsById(adm.getCpf());
        if (verificaCpf) {
            ar.save(adm);
            System.out.println("Cadastro Realizado com Sucesso");
        } else {
            System.out.println("Falha ao Cadastrar");
        }
        return "/login/login-adm";
    }

    @GetMapping("/interna-adm")
    public String acessoPageInternaAdm() {
        String vaiPara = "";
        if (acessoAdm) {
            vaiPara = "interna/interna-adm";
        } else {
            vaiPara = "login/login-adm";
        }
        return vaiPara;
    }

    @PostMapping("acesso-adm")
    public String acessoAdm(@RequestParam String cpf,
            @RequestParam String senha) {
        try {
            boolean verificaCpf = ar.existsById(cpf);
            boolean verificaSenha = ar.findByCpf(cpf).getSenha().equals(senha);
            String url = "";
            if (verificaCpf && verificaSenha) {
                acessoAdm = true;
                url = "redirect:/interna-adm";
            } else {
                url = "redirect:/login-adm";
                System.out.println("Erro de login");
            }
            return url;
        } catch (Exception e) {
            System.out.println("Erro de login");
            return "redirect:/login-adm";
        }
    }
}