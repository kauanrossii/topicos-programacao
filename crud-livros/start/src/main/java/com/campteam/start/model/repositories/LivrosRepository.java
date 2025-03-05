package com.campteam.start.model.repositories;

import com.campteam.start.model.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepository extends JpaRepository<Livro, Long> {
}
