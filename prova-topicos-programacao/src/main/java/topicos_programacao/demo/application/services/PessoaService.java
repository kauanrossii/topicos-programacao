package topicos_programacao.demo.application.services;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import topicos_programacao.demo.domain.pessoa.entities.Pessoa;
import topicos_programacao.demo.domain.trabalho.entities.Trabalho;
import topicos_programacao.demo.repositories.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service()
public class PessoaService {
    @Autowired()
    private PessoaRepository pessoaRepository;

    @Autowired()
    private TrabalhoService trabalhoService;

    public Long create(String nome, String cpf) {
        Pessoa pessoa = new Pessoa(nome, cpf);
        Pessoa novaPessoa = pessoaRepository.save(pessoa);
        return novaPessoa.getId();
    }

    public Pessoa findById(Long id) {
        return this.pessoaRepository.findById(id).orElseThrow();
    }

    public List<Pessoa> findAll() {
        return this.pessoaRepository.findAll();
    }

    public void delete(Long id) {
        this.pessoaRepository.deleteById(id);
    }

    public void vincularTrabalho(Long id, Long trabalhoId) throws BadRequestException {
        Pessoa pessoa = findById(id);
        Trabalho trabalho = this.trabalhoService.findById(id);
        pessoa.adicionarTrabalho(trabalho);
        this.pessoaRepository.save(pessoa);
    }

    public void removerTrabalho(Long id, Long trabalhoId) {
        Pessoa pessoa = findById(id);
        pessoa.removerTrabalho(id);
        this.pessoaRepository.save(pessoa);
    }

    public void update(Long id, String nome, String cpf) {
        Pessoa pessoa = findById(id);
        pessoa.setNome(nome);
        pessoa.setCpf(cpf);
        this.pessoaRepository.save(pessoa);
    }
}
