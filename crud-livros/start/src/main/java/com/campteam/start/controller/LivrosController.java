package com.campteam.start.controller;

import com.campteam.start.controller.dtos._shared.EntityIdDto;
import com.campteam.start.controller.dtos.livros.CreateLivroDto;
import com.campteam.start.controller.dtos.livros.UpdateLivroDto;
import com.campteam.start.model.entities.Livro;
import com.campteam.start.model.services.LivrosService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivrosController {
    @Autowired
    LivrosService livrosService;

    @GetMapping("/livros/{id}")
    public Livro findById(@PathVariable Long id) throws BadRequestException {
        return livrosService.findById(id);
    }

    @GetMapping("/livros")
    public List<Livro> findAll() {
        return livrosService.findAll();
    }

    @PostMapping("/livros")
    public EntityIdDto<Long> create(@RequestBody CreateLivroDto dto) {
        var id = livrosService.create(dto);
        return new EntityIdDto<Long>(id);
    }

    @PutMapping("/livros/{id}")
    public void update(@PathVariable Long id, @RequestBody UpdateLivroDto dto) throws BadRequestException {
        livrosService.update(id, dto);
    }

    @DeleteMapping("/livros/{id}")
    public void deleteById(@PathVariable Long id) {
        livrosService.deleteById(id);
    }
}
