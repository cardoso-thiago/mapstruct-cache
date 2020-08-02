package br.com.cardoso.mapstructcache.entity.builder;

import br.com.cardoso.mapstructcache.entity.DataEntity;

import java.time.LocalDateTime;

public final class DataEntityBuilder {
    private String descricao;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private Long numeroAleatorio;

    private DataEntityBuilder() {
    }

    public static DataEntityBuilder aDataEntity() {
        return new DataEntityBuilder();
    }

    public DataEntityBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public DataEntityBuilder creationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public DataEntityBuilder modificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
        return this;
    }

    public DataEntityBuilder numeroAleatorio(Long numeroAleatorio) {
        this.numeroAleatorio = numeroAleatorio;
        return this;
    }

    public DataEntity build() {
        return new DataEntity(descricao, creationDate, modificationDate, numeroAleatorio);
    }
}
