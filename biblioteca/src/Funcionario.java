public class Funcionario {
    protected String nome;
    protected float salario;

    public Funcionario(){}

    public Funcionario(String nome, float salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String mudarSalario(float novoSalario){
        var antigoSalario = getSalario();
        setSalario(novoSalario);
        return "O salário anterior de R$" + String.format("%.3f", antigoSalario) + " foi alterado para R$" + String.format("%.3f", salario);
    }

    @Override
    public String toString(){
        return "======== Dados do Funcionario ======== \nNome: " + nome + "\nSalário: " + String.format("%.3f", salario);
    }
}
