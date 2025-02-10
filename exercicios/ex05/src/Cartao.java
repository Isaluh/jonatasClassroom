public class Cartao extends Pagamento{
    @Override
    public double calcularValor(double valor) {
        return valor * 1.02;
    }
}
