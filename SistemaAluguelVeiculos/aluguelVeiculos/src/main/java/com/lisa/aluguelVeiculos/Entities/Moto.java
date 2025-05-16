package com.lisa.aluguelVeiculos.Entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MOTO") 
public class Moto extends Veiculo {

    private boolean temCarenagem;

    public Moto() {}

    public Moto(String modelo, boolean temCarenagem) {
        super(modelo, TiposVeiculo.MOTO);
        this.temCarenagem = temCarenagem;
    }

    @Override
    public String getDetalhes() {
        return "Moto Modelo: " + getModelo() + ", Tem Carenagem: " + (temCarenagem ? "Sim" : "Não");
    }

    public boolean isTemCarenagem() {
        return temCarenagem;
    }

    public void setTemCarenagem(boolean temCarenagem) {
        this.temCarenagem = temCarenagem;
    }
}

