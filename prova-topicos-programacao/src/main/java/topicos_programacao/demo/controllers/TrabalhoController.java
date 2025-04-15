package topicos_programacao.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import topicos_programacao.demo.application.services.TrabalhoService;
import topicos_programacao.demo.controllers.dtos.trabalho.AtualizarTrabalhoDto;
import topicos_programacao.demo.controllers.dtos.trabalho.CriarTrabalhoDto;
import topicos_programacao.demo.domain.trabalho.entities.Trabalho;

import java.util.List;

@RestController()
public class TrabalhoController {
    @Autowired
    private TrabalhoService trabalhoService;

    @GetMapping("/trabalhos")
    public List<Trabalho> findAll() {
        return this.trabalhoService.findAll();
    }

    @GetMapping("/trabalhos/{id}")
    public Trabalho findById(@PathVariable() Long id) {
        return this.trabalhoService.findById(id);
    }

    @PostMapping("/trabalhos")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody() CriarTrabalhoDto dto) {
        this.trabalhoService.create(dto.getNome(), dto.getTipoRegime(), dto.getTipoCargaHoraria());
    }

    @PutMapping("/trabalhos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable() Long id, @RequestBody() AtualizarTrabalhoDto dto) {
        this.trabalhoService.update(id, dto.getNome(), dto.getTipoRegime(), dto.getTipoCargaHoraria());
    }

    @DeleteMapping("/trabalhos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable() Long id) {
        this.trabalhoService.delete(id);
    }
}
