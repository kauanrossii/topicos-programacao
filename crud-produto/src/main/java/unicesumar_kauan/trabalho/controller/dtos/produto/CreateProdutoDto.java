package unicesumar_kauan.trabalho.controller.dtos.produto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateProdutoDto {
    public String nome;

    @Min(value = 0, message = "O preço não pode ser menor do que zero")
    public Double preco;

    @Min(value = 0, message = "O preço não pode ser menor do que zero")
    public Integer quantidadeEmEstoque;
}
