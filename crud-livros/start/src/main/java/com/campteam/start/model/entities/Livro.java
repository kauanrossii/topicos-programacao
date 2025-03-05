package com.campteam.start.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Livro")
public class Livro {

    public Livro(String nome, String autor) {
        this.nome = nome;
        this.autor = autor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String nome;
    public String autor;
}
