package topicos_programacao.demo.domain.trabalho.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import topicos_programacao.demo.domain.trabalho.enums.TipoCargaHoraria;
import topicos_programacao.demo.domain.trabalho.enums.TipoRegime;

@Entity(name = "Trabalho")
public class Trabalho {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String nome;
    TipoCargaHoraria tipoCargaHoraria;
    TipoRegime tipoRegime;

    protected Trabalho() { }

    public Trabalho(String nome, TipoCargaHoraria tipoCargaHoraria, TipoRegime tipoRegime) {
        this.nome = nome;
        this.tipoCargaHoraria = tipoCargaHoraria;
        this.tipoRegime = tipoRegime;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCargaHoraria getTipoCargaHoraria() {
        return tipoCargaHoraria;
    }

    public void setTipoCargaHoraria(TipoCargaHoraria tipoCargaHoraria) {
        this.tipoCargaHoraria = tipoCargaHoraria;
    }

    public TipoRegime getTipoRegime() {
        return tipoRegime;
    }

    public void setTipoRegime(TipoRegime tipoRegime) {
        this.tipoRegime = tipoRegime;
    }

    public void AtualizarInformacoes(String nome, TipoCargaHoraria tipoCargaHoraria, TipoRegime tipoRegime) {
        this.nome = nome;
        this.tipoCargaHoraria = tipoCargaHoraria;
        this.tipoRegime = tipoRegime;
    }
}
