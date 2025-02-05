// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Heloisa", 1.100f);
        Gerente gerente = new Gerente("Heitor", 25.000f, "Gerência de Tecnologia");
        Livro livro = new Livro("Titulo qualquer", "Autor qualquer", 2025);


        System.out.println(funcionario + "\n");
        System.out.println(gerente + "\n");
        System.out.println(livro + "\n");

        System.out.println(funcionario.mudarSalario(5.000f) + "\n");

        System.out.println(funcionario);
    }
}