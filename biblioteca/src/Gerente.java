public class Gerente extends Funcionario{
    private String departamento;

    public Gerente(String departamento) {
        this.departamento = departamento;
    }

    public Gerente(String nome, float salario, String departamento) {
        super(nome, salario);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString(){
        return "======== Dados do Gerente ======== \nNome: " + nome + "\nSalário: " + String.format("%.3f", salario) + "\nDepartamento: " + departamento;
    }
}
