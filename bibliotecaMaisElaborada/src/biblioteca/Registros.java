package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Registros {
    private List<Livro> livros;
    private List<Leitores> leitores;
    private List<Emprestimo> emprestimos;

    public Registros() {
        livros = new ArrayList<>();
        leitores = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro " + livro.getTitulo() + " cadastrado!");
    }

    public void registrarLeitores(Leitores leitor) {
        leitores.add(leitor);
        System.out.println("Leitor " + leitor.getNome() + " registrado!");
    }

    public void emprestarLivro(Leitores leitor, Livro livro) {
        leitor.registrarEmprestimo(livro);
        Emprestimo emprestimo = new Emprestimo(leitor, livro);
        emprestimos.add(emprestimo);
    }

    public void devolverLivro(Leitores leitor, Livro livro) {
        leitor.devolverLivro(livro);
        for (Emprestimo emp : emprestimos) {
            if (emp.getLeitores().equals(leitor) && emp.getLivro().equals(livro)) {
                emp.registrarDevolucao();
                break;
            }
        }
    }
}
