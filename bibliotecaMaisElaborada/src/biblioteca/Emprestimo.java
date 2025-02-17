package biblioteca;

import java.util.Date;

public class Emprestimo {
    private Leitores leitores;
    private Livro livro;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(Leitores leitores, Livro livro) {
        this.leitores = leitores;
        this.livro = livro;
        this.dataEmprestimo = new Date();
    }

    public Leitores getLeitores() {
        return leitores;
    }

    public void setLeitores(Leitores leitores) {
        this.leitores = leitores;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void registrarDevolucao() {
        this.dataDevolucao = new Date();
        System.out.println("Devolução do livro: " + livro.getTitulo());
    }
}
