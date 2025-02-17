package biblioteca;

public abstract class Leitores {
    private String nome;
    private String cpf;
    private int id;

    public Leitores(String nome, String cpf, int id) {
        this.nome = nome;
        this.cpf = cpf;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void registrarEmprestimo(Livro livro);
    public abstract void devolverLivro(Livro livro);
}
