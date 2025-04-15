package topicos_programacao.demo.controllers;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import topicos_programacao.demo.application.services.PessoaService;
import topicos_programacao.demo.controllers.dtos.common.EntityIdDto;
import topicos_programacao.demo.controllers.dtos.pessoa.AtualizarPessoaDto;
import topicos_programacao.demo.controllers.dtos.pessoa.CriarPessoaDto;
import topicos_programacao.demo.controllers.dtos.pessoa.VincularTrabalhoDto;
import topicos_programacao.demo.domain.pessoa.entities.Pessoa;

import java.util.List;

@RestController()
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/pessoas")
    public List<Pessoa> findAll() {
        return this.pessoaService.findAll();
    }

    @GetMapping("/pessoas/{id}")
    public Pessoa findById(@PathVariable() Long id) {
        return this.pessoaService.findById(id);
    }

    @PostMapping("/pessoas")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody() CriarPessoaDto dto) {
        this.pessoaService.create(dto.getNome(), dto.getCpf());
    }

    @PutMapping("/pessoas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable() Long id, @RequestBody()AtualizarPessoaDto atualizarPessoaDto) {
        this.pessoaService.update(id, atualizarPessoaDto.getNome(), atualizarPessoaDto.getCpf());
    }

    @DeleteMapping("/pessoas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable() Long id) {
        this.pessoaService.delete(id);
    }

    @PostMapping("/pessoas/{id}/trabalhos")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void vincularTrabalho(@PathVariable() Long id, @RequestBody()VincularTrabalhoDto dto) throws BadRequestException {
        this.pessoaService.vincularTrabalho(id, dto.getTrabalhoId());
    }

    @DeleteMapping("/pessoas/{id}/trabalhos/{trabalhoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerTrabalho(@PathVariable() Long id, @PathVariable() Long trabalhoId) {
        this.pessoaService.removerTrabalho(id, trabalhoId);
    }
}
