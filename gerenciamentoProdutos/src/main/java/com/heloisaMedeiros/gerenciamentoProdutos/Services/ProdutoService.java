package com.heloisaMedeiros.gerenciamentoProdutos.Services;

import com.heloisaMedeiros.gerenciamentoProdutos.Entities.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();
    private long contadorId = 0;

    public List<Produto> listar(){
        return produtos;
    }

    public Produto addProduto(Produto produto){
        produtos.add(produto);
        produto.setId(contadorId++);
        return produto;
    }
}
