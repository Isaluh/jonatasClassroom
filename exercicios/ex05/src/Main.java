public class Main {
    public static void main(String[] args) {
        Pagamento cartao = new Cartao();
        Pagamento boleto = new Boleto();

        double valor = 1000.0;

        cartao.exibirDetalhes();
        System.out.println("Valor do pagamento no cartão: " + cartao.calcularValor(valor));

        boleto.exibirDetalhes();
        System.out.println("Valor do pagamento no boleto: " + boleto.calcularValor(valor));
    }
}