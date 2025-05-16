package com.lisa.aluguelVeiculos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lisa.aluguelVeiculos.Entities.Aluguel;
import com.lisa.aluguelVeiculos.Entities.Cliente;
import com.lisa.aluguelVeiculos.Entities.Veiculo;
import com.lisa.aluguelVeiculos.Services.AluguelService;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @PostMapping("/cliente")
    public Cliente cadastrarCliente(@RequestParam String nome, @RequestParam String cpf) {
        return aluguelService.cadastrarCliente(nome, cpf);
    }

    @PostMapping("/veiculo")
    public Veiculo cadastrarVeiculo(@RequestParam String modelo, @RequestParam Veiculo.TiposVeiculo tipo, 
                                     @RequestParam Object especifico) {
        return aluguelService.cadastrarVeiculo(modelo, tipo, especifico);
    }

    @PostMapping("/registrar")
    public Aluguel registrarAluguel(@RequestParam int clienteId, @RequestParam int veiculoId, 
                                    @RequestParam String dataInicio, @RequestParam String dataFim) {
        return aluguelService.registrarAluguel(clienteId, veiculoId, LocalDate.parse(dataInicio), LocalDate.parse(dataFim));
    }

    @GetMapping("/ativos")
    public List<Aluguel> listarAlugueisAtivos() {
        return aluguelService.listarAlugueisAtivos();
    }

    @PostMapping("/devolver")
    public void devolverVeiculo(@RequestParam int aluguelId) {
        aluguelService.devolverVeiculo(aluguelId);
    }
}
