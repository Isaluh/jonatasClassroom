public class Main {
    public static void main(String[] args) {
        Forma retangulo = new Retangulo(5, 3);
        Forma triangulo = new Triangulo(4, 6);
        Forma circulo = new Circulo(7);

        retangulo.exibirArea();
        triangulo.exibirArea();
        circulo.exibirArea();
    }
}