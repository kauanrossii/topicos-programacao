package unicesumar_kauan.trabalho.model.services;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicesumar_kauan.trabalho.controller.dtos.produto.CreateProdutoDto;
import unicesumar_kauan.trabalho.controller.dtos.produto.UpdateProdutoDto;
import unicesumar_kauan.trabalho.model.entities.Produto;
import unicesumar_kauan.trabalho.model.repositories.ProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public Produto findById(Long id) throws BadRequestException {
        return produtoRepository.findById(id).orElseThrow(BadRequestException::new);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Long create(CreateProdutoDto dto) {
        var produto = new Produto(
                dto.nome,
                dto.preco,
                dto.quantidadeEmEstoque
        );
        var produtoSalvo = produtoRepository.save(produto);
        return produtoSalvo.id;
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }

    public void update(Long id, UpdateProdutoDto dto) throws BadRequestException {
        var produto = findById(id);
        produto.preco = dto.preco;
        produto.nome = dto.nome;
        produto.quantidadeEmEstoque = dto.quantidadeEmEstoque;
        produtoRepository.save(produto);
    }
}
