package com.lisa.aluguelVeiculos.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lisa.aluguelVeiculos.Entities.Aluguel;
import com.lisa.aluguelVeiculos.Entities.Carro;
import com.lisa.aluguelVeiculos.Entities.Cliente;
import com.lisa.aluguelVeiculos.Entities.Moto;
import com.lisa.aluguelVeiculos.Entities.Veiculo;
import com.lisa.aluguelVeiculos.Repositories.AluguelRepository;
import com.lisa.aluguelVeiculos.Repositories.ClienteRepository;
import com.lisa.aluguelVeiculos.Repositories.VeiculoRepository;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(String nome, String cpf) {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        return clienteRepository.save(cliente);
    }

    public Veiculo cadastrarVeiculo(String modelo, Veiculo.TiposVeiculo tipo, Object especifico) {
        Veiculo veiculo = null;
        if (tipo == Veiculo.TiposVeiculo.CARRO) {
            int numeroDePortas = (Integer) especifico;  
            veiculo = new Carro(modelo, numeroDePortas);
        } else if (tipo == Veiculo.TiposVeiculo.MOTO) {
            boolean temCarenagem = (Boolean) especifico; 
            veiculo = new Moto(modelo, temCarenagem);
        }
        return veiculoRepository.save(veiculo);
    }

    public Aluguel registrarAluguel(int clienteId, int veiculoId, LocalDate dataInicio, LocalDate dataFim) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Veiculo veiculo = veiculoRepository.findById(veiculoId).orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        if (!veiculo.isDisponivel()) {
            throw new RuntimeException("Veículo não disponível para aluguel");
        }

        Aluguel aluguel = new Aluguel();
        aluguel.setCliente(cliente);
        aluguel.setVeiculo(veiculo);
        aluguel.setDataInicio(dataInicio);
        aluguel.setDataFim(dataFim);

        veiculo.setDisponivel(false);

        veiculoRepository.save(veiculo);
        return aluguelRepository.save(aluguel);
    }

    public List<Aluguel> listarAlugueisAtivos() {
        return aluguelRepository.findByDataFimIsNull();
    }

    public void devolverVeiculo(int aluguelId) {
        Aluguel aluguel = aluguelRepository.findById(aluguelId).orElseThrow(() -> new RuntimeException("Aluguel não encontrado"));
        Veiculo veiculo = aluguel.getVeiculo();

        veiculo.setDisponivel(true);
        veiculoRepository.save(veiculo);

        aluguel.setDataFim(LocalDate.now());
        aluguelRepository.save(aluguel);
    }
}