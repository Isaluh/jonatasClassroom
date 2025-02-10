public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto();

        produto.setNome("Bolacha");
        produto.setPreco(10.50);
        produto.setQuantidadeEstoq(2);

        System.out.println(produto.toString());
        System.out.println(produto.addEstoque(5));
        System.out.println(produto.removeEstoque(4));
        System.out.println(produto.removeEstoque(4));
        System.out.println(produto.toString());
    }
}