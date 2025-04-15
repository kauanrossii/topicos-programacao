package topicos_programacao.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import topicos_programacao.demo.domain.pessoa.entities.Pessoa;

@Repository()
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
