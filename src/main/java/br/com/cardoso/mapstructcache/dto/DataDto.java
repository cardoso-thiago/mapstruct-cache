package br.com.cardoso.mapstructcache.dto;

import br.com.cardoso.mapstructcache.dto.builder.DataDtoBuilder;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class DataDto {
    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;
    @NotNull(message = "A data é obrigatória")
    private LocalDateTime date;
    @NotNull(message = "O número aleatório é obrigatório")
    @Min(value = 1L, message = "O valor deve ser um número positivo")
    @Max(value = Integer.MAX_VALUE, message = "Ultrapassou o valor máximo permitido")
    private Long numeroAleatorio;

    public DataDto(String descricao, LocalDateTime date, Long numeroAleatorio) {
        this.descricao = descricao;
        this.date = date;
        this.numeroAleatorio = numeroAleatorio;
    }

    //Necessário para o MapStruct
    public static DataDtoBuilder builder() {
        return DataDtoBuilder.aDataDto();
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Long getNumeroAleatorio() {
        return numeroAleatorio;
    }
}
