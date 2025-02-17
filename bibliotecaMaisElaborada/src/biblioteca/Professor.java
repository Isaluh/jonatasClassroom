package biblioteca;

public class Professor extends Leitores {
    private int limiteEmprestimos = 5;

    public Professor(String nome, String cpf, int id) {
        super(nome, cpf, id);
    }

    @Override
    public void registrarEmprestimo(Livro livro) {
        if (limiteEmprestimos > 0 && livro.isDisponivel()) {
            livro.emprestar();
            limiteEmprestimos--;
            System.out.println("O(a) professor(a) " + getNome() + " pegou o livro: " + livro.getTitulo());
        } else {
            System.out.println("Limite de empréstimos atingido ou livro não disponível.");
        }
    }

    @Override
    public void devolverLivro(Livro livro) {
        livro.devolver();
        limiteEmprestimos++;
        System.out.println("O(a) professor(a) " + getNome() + " devolveu o livro: " + livro.getTitulo());
    }
}
