package unicesumar_kauan.trabalho.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unicesumar_kauan.trabalho.controller.dtos._shared.EntityIdDto;
import unicesumar_kauan.trabalho.controller.dtos.produto.CreateProdutoDto;
import unicesumar_kauan.trabalho.controller.dtos.produto.UpdateProdutoDto;
import unicesumar_kauan.trabalho.model.entities.Produto;
import unicesumar_kauan.trabalho.model.services.ProdutoService;

import java.util.List;

@RestController
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @GetMapping("/produtos/{id}")
    public Produto findById(@PathVariable Long id) throws BadRequestException {
        return produtoService.findById(id);
    }

    @GetMapping("/produtos")
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @PostMapping("/produtos")
    public EntityIdDto create(@RequestBody CreateProdutoDto dto) {
        var produtoId = produtoService.create(dto);
        return new EntityIdDto(produtoId);
    }

    @PutMapping("/produtos/{id}")
    public void update(@PathVariable Long id, @RequestBody UpdateProdutoDto dto) throws BadRequestException {
        produtoService.update(id, dto);
    }

    @DeleteMapping("/produtos/{id}")
    public void delete(@PathVariable Long id) {
        produtoService.deleteById(id);
    }
}
