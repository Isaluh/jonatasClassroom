package biblioteca;

public class Main {
    public static void main(String[] args) {
        Registros registros = new Registros();

        Livro livro1 = new Livro("A Rainha Vermelha", "Victoria Aveyard", 2015, "005");
        Livro livro2 = new Livro("Seis de Corvos", "Leigh Bardugo", 2015, "002");

        registros.cadastrarLivro(livro1);
        registros.cadastrarLivro(livro2);
        System.out.println();

        Leitores usuario1 = new Aluno("Carlos", "123456789", 1);
        Leitores usuario2 = new Professor("Maria", "987654321", 2);
        System.out.println();

        registros.registrarLeitores(usuario1);
        registros.registrarLeitores(usuario2);
        System.out.println();

        registros.emprestarLivro(usuario1, livro1);
        registros.emprestarLivro(usuario2, livro2); 
        System.out.println();

        registros.emprestarLivro(usuario1, livro1); 
        System.out.println();

        registros.devolverLivro(usuario1, livro1);  
        registros.devolverLivro(usuario2, livro2);  
    }
}
