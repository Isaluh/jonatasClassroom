public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEstoq;

    public Produto() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoq() {
        return quantidadeEstoq;
    }

    public void setQuantidadeEstoq(int quantidadeEstoq) {
        this.quantidadeEstoq = quantidadeEstoq;
    }

    public String addEstoque(int mais){
        this.quantidadeEstoq += mais;
        return "Adicionado " + mais + " produtos ao estoque. Total: " + quantidadeEstoq;
    }

    public String removeEstoque(int menos){
        if((this.quantidadeEstoq - menos) < 0){
            return "Impossivel remover produtos inexistentes. Total de produtos no estoque: " + quantidadeEstoq;
        }
        this.quantidadeEstoq -= menos;
        return "Removido " + menos + " produtos do estoque. Total: " + quantidadeEstoq;
    }



    @Override
    public String toString(){
        return "========== Informações do produto ========== \nNome: " + nome + "\nPreço: R$" + preco + "\nQuantidade em estoque: " + quantidadeEstoq;
    }
}
