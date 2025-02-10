public class Moto extends Veiculo{
    private int cilindradas;

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public String exibirDetalhes(){
        return "========== Informações da moto ========== \nMarca: " + getMarca() + "\nModelo: " + getModelo() + "\nAno: " + getAno() + "\nCilindradas: " + cilindradas;
    }
}
