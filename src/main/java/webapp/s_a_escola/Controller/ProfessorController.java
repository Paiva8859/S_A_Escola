package webapp.s_a_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public String cadastrarProfessor(@RequestParam String cpf,
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String senha,
            @RequestParam String materia) {
        Professor pro = new Professor();
        pro.setCpf(cpf);
        pro.setNome(nome);
        pro.setEmail(email);
        pro.setSenha(senha);

        switch (materia) {
            case "Exatas":
                pro.setMateriaExatas(true);
                break;
            case "Humanas":
                pro.setMateriaHumanas(true);
                break;
            case "Ciências da Natureza":
                pro.setMateriaCiencias(true);
                break;
            case "Linguagens":
                pro.setMateriaLinguagens(true);
                break;
            default:

                break;
        }

        pr.save(pro);

        System.out.println("Cadastro Realizado com Sucesso");

        return "/interna/interna-adm";
    }

    @PostMapping("acesso-professor")
    public String acessoProfessor(@RequestParam String cpf,
            @RequestParam String senha,
            HttpServletRequest request) {
        try {
            // Verificar se o CPF e a senha correspondem a um professor
            Professor professor = pr.findByCpf(cpf);
            if (professor != null && professor.getSenha().equals(senha)) {
                // Se o professor foi encontrado e a senha está correta, armazenar seu ID na
                // sessão
                HttpSession session = request.getSession();
                session.setAttribute("professorId", professor.getCpf());
                // Redirecionar para a página interna do professor
                return "redirect:/interna-professor";
            } else {
                // Se o login falhar, redirecionar para a página de login com uma mensagem de
                // erro
                return "redirect:/login-professor?error=1";
            }
        } catch (Exception e) {
            // Se ocorrer um erro, redirecionar para a página de login com uma mensagem de
            // erro
            return "redirect:/login-professor?error=1";
        }
    }

    @GetMapping("/interna-professor")
    public String acessoPageInternaProfessor(HttpServletRequest request, Model model) {
        // Obter o CPF do professor armazenado na sessão
        HttpSession session = request.getSession();
        String cpf = (String) session.getAttribute("professorId");

        // Verificar se o CPF do professor está na sessão
        if (cpf != null) {
            // Buscar o professor pelo CPF
            Professor professor = pr.findByCpf(cpf);

            // Verificar se o professor foi encontrado
            if (professor != null) {
                model.addAttribute("professor", professor);
                return "interna/interna-professor";
            } else {
                // Se o professor não foi encontrado, redirecionar para a página de login
                return "redirect:/login-professor";
            }
        } else {
            // Se o CPF do professor não estiver na sessão, redirecionar para a página de
            // login
            return "redirect:/login-professor";
        }
    }

    @PostMapping("/pesquisar-aluno")
    public String pesquisarAluno(@RequestParam String nome, HttpServletRequest request, Model model) {
        // Obtém o CPF do professor armazenado na sessão
        HttpSession session = request.getSession();
        String cpf = (String) session.getAttribute("professorId");

        // Verifica se o CPF do professor está na sessão
        if (cpf != null) {
            // Busca o professor pelo CPF
            Professor professor = pr.findByCpf(cpf);

            // Verifica se o professor foi encontrado
            if (professor != null) {
                // Adiciona o professor ao modelo
                model.addAttribute("professor", professor);

                // Busca os alunos pelo nome
                Iterable<Aluno> alunos = alr.findByNomeContaining(nome);
                model.addAttribute("alunos", alunos);

                // Retorna a página interna do professor
                return "interna/interna-professor";
            } else {
                // Se o professor não foi encontrado, redireciona para a página de login
                return "redirect:/login-professor";
            }
        } else {
            // Se o CPF do professor não estiver na sessão, redireciona para a página de
            // login
            return "redirect:/login-professor";
        }
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
