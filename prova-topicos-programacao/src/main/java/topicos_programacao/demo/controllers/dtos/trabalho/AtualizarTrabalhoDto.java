package topicos_programacao.demo.controllers.dtos.trabalho;

import topicos_programacao.demo.domain.trabalho.enums.TipoCargaHoraria;
import topicos_programacao.demo.domain.trabalho.enums.TipoRegime;

public class AtualizarTrabalhoDto {
    public String nome;
    public TipoRegime tipoRegime;
    public TipoCargaHoraria tipoCargaHoraria;

    public String getNome() {
        return nome;
    }

    public TipoRegime getTipoRegime() {
        return tipoRegime;
    }

    public TipoCargaHoraria getTipoCargaHoraria() {
        return tipoCargaHoraria;
    }

    public AtualizarTrabalhoDto() {

    }
}
