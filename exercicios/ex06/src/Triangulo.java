public class Triangulo implements Forma{
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }

    public void exibirArea() {
        System.out.println("Área do Triângulo: " + calcularArea());
    }
}
