public class ControladorRest {
    package com.ContraladorRest.controlador;

import com.ControladorRest.modelo.Produto;
import com.ConttoladorRest.repositorio.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/produtos")
    public class ProdutoController {

        @Autowired
        private ProdutoRepository produtoRepository;


        @GetMapping
        public List<Produto> listarProdutos() {
            return produtoRepository.findAll();
        }


        @PostMapping
        public Produto criarProduto(@RequestBody Produto produto) {
            return produtoRepository.save(produto);
        }


        @GetMapping("/{id}")
        public Produto obterProdutoPorId(@PathVariable Long id) {
            return produtoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));
        }


        @PutMapping("/{id}")
        public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
            return produtoRepository.findById(id)
                    .map(produto -> {
                        produto.setNome(produtoAtualizado.getNome());
                        produto.setPreco(produtoAtualizado.getPreco());
                        return produtoRepository.save(produto);
                    })
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));
        }


        @DeleteMapping("/{id}")
        public void deletarProduto(@PathVariable Long id) {
            produtoRepository.deleteById(id);
        }
    }

}
