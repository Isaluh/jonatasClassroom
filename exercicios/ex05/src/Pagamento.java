public abstract class Pagamento {
    private double valor;

    public abstract double calcularValor(double valor);

    public void exibirDetalhes() {
        System.out.println("========= Detalhes do pagamento =========");
    }
}
