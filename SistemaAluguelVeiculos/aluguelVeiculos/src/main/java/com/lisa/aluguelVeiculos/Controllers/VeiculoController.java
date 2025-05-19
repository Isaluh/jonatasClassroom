package com.lisa.aluguelVeiculos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lisa.aluguelVeiculos.Entities.Veiculo;
import com.lisa.aluguelVeiculos.Services.VeiculoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public Veiculo cadastrarVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.cadastrarVeiculo(veiculo);
    }

    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculoService.listarVeiculos();
    }

    @GetMapping("/{id}")
    public Optional<Veiculo> buscarVeiculoPorId(@PathVariable Integer id) {
        return veiculoService.buscarVeiculoPorId(id);
    }

    @GetMapping("/disponibilidade/{id}")
    public boolean verificarDisponibilidade(@PathVariable int id) {
        return veiculoService.verificarDisponibilidade(id);
    }

    @PutMapping("/devolver/{id}")
    public Veiculo devolverVeiculo(@PathVariable int id) {
        return veiculoService.devolverVeiculo(id);
    }
}

