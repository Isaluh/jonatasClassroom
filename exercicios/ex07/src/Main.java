public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Carlos", 3000.0);
        Funcionario gerente = new Gerente("Ana", 6000.0);
        Funcionario desenvolvedor = new Desenvolvedor("João", 4000.0);

        System.out.println("======== Detalhes do Funcionário ========");
        funcionario.exibirDetalhes();
        System.out.println("Bônus: R$" + funcionario.calcularBonus());
        System.out.println();

        System.out.println("======== Detalhes do Gerente ========");
        gerente.exibirDetalhes();
        System.out.println("Bônus: R$" + gerente.calcularBonus());
        System.out.println();

        System.out.println("======== Detalhes do Desenvolvedor: ========");
        desenvolvedor.exibirDetalhes();
        System.out.println("Bônus: R$" + desenvolvedor.calcularBonus());
    }
}