public class Main {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo();
        Carro carro = new Carro();
        Moto moto = new Moto();

        veiculo.setMarca("FIAT");
        veiculo.setModelo("Argo");
        veiculo.setAno(2020);

        carro.setMarca("NISSAN");
        carro.setModelo("R34");
        carro.setAno(2002);
        carro.setNumeroPortas(2);

        moto.setMarca("YAMAHA");
        moto.setModelo("NMax");
        moto.setAno(2021);
        moto.setCilindradas(160);

        System.out.println(veiculo.exibirDetalhes());
        System.out.println(carro.exibirDetalhes());
        System.out.println(moto.exibirDetalhes());
    }
}