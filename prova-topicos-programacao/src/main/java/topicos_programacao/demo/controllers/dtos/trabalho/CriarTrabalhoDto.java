package topicos_programacao.demo.controllers.dtos.trabalho;

import topicos_programacao.demo.controllers.dtos.pessoa.CriarPessoaDto;
import topicos_programacao.demo.domain.trabalho.enums.TipoCargaHoraria;
import topicos_programacao.demo.domain.trabalho.enums.TipoRegime;

public class CriarTrabalhoDto {
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

    public CriarTrabalhoDto() {

    }
}
