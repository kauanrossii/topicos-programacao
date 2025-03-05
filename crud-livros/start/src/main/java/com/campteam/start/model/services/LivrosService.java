package com.campteam.start.model.services;

import com.campteam.start.controller.dtos.livros.CreateLivroDto;
import com.campteam.start.controller.dtos.livros.UpdateLivroDto;
import com.campteam.start.model.entities.Livro;
import com.campteam.start.model.repositories.LivrosRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivrosService {
    @Autowired
    LivrosRepository livrosRepository;

    public Livro findById(Long id) throws BadRequestException {
        return livrosRepository.findById(id).orElseThrow();
    }

    public List<Livro> findAll() {
        return livrosRepository.findAll();
    }

    public Long create(CreateLivroDto dto) {
        var livro = new Livro(dto.nome, dto.autor);
        var livroSalvo = livrosRepository.save(livro);
        return livroSalvo.id;
    }

    public void deleteById(Long id) {
        livrosRepository.deleteById(id);
    }

    public void update(Long id, UpdateLivroDto dto) throws BadRequestException {
        var antigoLivro = findById(id);
        antigoLivro.nome = dto.nome;
        antigoLivro.autor = dto.autor;
        livrosRepository.save(antigoLivro);
    }
}
