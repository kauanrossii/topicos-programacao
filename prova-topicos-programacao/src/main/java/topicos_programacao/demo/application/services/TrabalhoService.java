package topicos_programacao.demo.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import topicos_programacao.demo.domain.pessoa.entities.Pessoa;
import topicos_programacao.demo.domain.trabalho.entities.Trabalho;
import topicos_programacao.demo.domain.trabalho.enums.TipoCargaHoraria;
import topicos_programacao.demo.domain.trabalho.enums.TipoRegime;
import topicos_programacao.demo.repositories.TrabalhoRepository;

import java.util.List;

@Service
public class TrabalhoService {
    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public Long create(String nome, TipoRegime tipoRegime, TipoCargaHoraria tipoCargaHoraria) {
        Trabalho trabalho = new Trabalho(nome, tipoCargaHoraria, tipoRegime);
        Trabalho novoTrabalho = trabalhoRepository.save(trabalho);
        return novoTrabalho.getId();
    }

    public Trabalho findById(Long id) {
        return this.trabalhoRepository.findById(id).orElseThrow();
    }

    public List<Trabalho> findAll() {
        return this.trabalhoRepository.findAll();
    }

    public void delete(Long id) {
        this.trabalhoRepository.deleteById(id);
    }

    public void update(Long id, String nome, TipoRegime tipoRegime, TipoCargaHoraria tipoCargaHoraria) {
        Trabalho trabalho = findById(id);
        trabalho.setNome(nome);
        trabalho.setTipoRegime(tipoRegime);
        trabalho.setTipoCargaHoraria(tipoCargaHoraria);
        this.trabalhoRepository.save(trabalho);
    }
}
