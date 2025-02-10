public class Boleto extends Pagamento{
    @Override
    public double calcularValor(double valor) {
        return valor;
    }
}
