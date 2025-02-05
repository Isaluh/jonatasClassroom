public class Livro {
    private String titulo;
    private String autor;
    private int ano_publicado;

    public Livro(String titulo, String autor, int ano_publicado) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano_publicado = ano_publicado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno_publicado() {
        return ano_publicado;
    }

    public void setAno_publicado(int ano_publicado) {
        this.ano_publicado = ano_publicado;
    }

    @Override
    public String toString(){
        return "======== Dados do livro ======== \nTitulo: " + titulo + "\nAutor: " + autor + "\nAno publicado: " + ano_publicado;
    }
}
