public class Carro extends Veiculo{
    private int numeroPortas;

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    @Override
    public String exibirDetalhes(){
        return "========== Informações do carro ========== \nMarca: " + getMarca() + "\nModelo: " + getModelo() + "\nAno: " + getAno() + "\nNº de portas: " + numeroPortas;
    }
}
