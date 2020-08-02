package br.com.cardoso.mapstructcache.dto.builder;

import br.com.cardoso.mapstructcache.dto.DataDto;

import java.time.LocalDateTime;

public final class DataDtoBuilder {
    private String descricao;
    private LocalDateTime date;
    private Long numeroAleatorio;

    private DataDtoBuilder() {
    }

    public static DataDtoBuilder aDataDto() {
        return new DataDtoBuilder();
    }

    public DataDtoBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public DataDtoBuilder date(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public DataDtoBuilder numeroAleatorio(Long numeroAleatorio) {
        this.numeroAleatorio = numeroAleatorio;
        return this;
    }

    public DataDto build() {
        return new DataDto(descricao, date, numeroAleatorio);
    }
}
