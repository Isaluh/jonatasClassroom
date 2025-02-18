package com.heloisaMedeiros.gerenciamentoProdutos.Controllers;

import com.heloisaMedeiros.gerenciamentoProdutos.Entities.Produto;
import com.heloisaMedeiros.gerenciamentoProdutos.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping()
    public List<Produto> listarProdutos(){
        return produtoService.listar();
    }

    @PostMapping("/add")
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return produtoService.addProduto(produto);
    }
}
