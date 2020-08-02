package br.com.cardoso.mapstructcache.dto;

import br.com.cardoso.mapstructcache.dto.builder.DataDtoBuilder;

import java.time.LocalDateTime;

public class DataDto {
    private String descricao;
    private LocalDateTime date;

    public DataDto(String descricao, LocalDateTime date) {
        this.descricao = descricao;
        this.date = date;
    }

    public static DataDtoBuilder builder() {
        return DataDtoBuilder.aDataDto();
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
