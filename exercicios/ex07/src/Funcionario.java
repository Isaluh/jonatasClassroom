public class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }
    public void exibirDetalhes() {
        System.out.println("Nome: " + nome + "\nSalário: R$" + salario);
    }

    public double calcularBonus() {
        return salario * 0.10;
    }
}
