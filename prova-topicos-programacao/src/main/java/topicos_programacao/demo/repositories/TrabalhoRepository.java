package topicos_programacao.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import topicos_programacao.demo.domain.trabalho.entities.Trabalho;

@Repository()
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {
}
