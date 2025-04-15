package topicos_programacao.demo.domain.pessoa.entities;

import jakarta.persistence.*;
import org.apache.coyote.BadRequestException;
import topicos_programacao.demo.domain.trabalho.entities.Trabalho;

import java.util.List;

@Entity(name = "Pessoa")
public class Pessoa {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String nome;
    String cpf;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pessoa_trabalho",
        joinColumns = @JoinColumn(name = "trabalho_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    )
    List<Trabalho> trabalhos;

    public long getId() {
        return id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    public void adicionarTrabalho(Trabalho trabalho) throws BadRequestException {
        if (isTrabalhoDuplicado(trabalho)) {
            throw new BadRequestException("O trabalho selecionado está duplicado");
        }

        trabalhos.add(trabalho);
    }

    private boolean isTrabalhoDuplicado(Trabalho trabalho) {
        return this.trabalhos
                .stream()
                .anyMatch(t ->
                        t.getId() == trabalho.getId()
                );
    }

    public void removerTrabalho(Long trabalhoId) {
        Trabalho trabalho = this.trabalhos
                .stream()
                .filter(t -> t.getId() == trabalhoId)
                .findFirst()
                .orElseThrow();

        this.trabalhos.remove(trabalho);
    }

    protected Pessoa() { }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
}
