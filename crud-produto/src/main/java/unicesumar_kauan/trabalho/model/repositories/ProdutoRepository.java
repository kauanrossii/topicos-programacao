package unicesumar_kauan.trabalho.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unicesumar_kauan.trabalho.model.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
