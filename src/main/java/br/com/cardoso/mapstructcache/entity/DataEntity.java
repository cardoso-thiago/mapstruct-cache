package br.com.cardoso.mapstructcache.entity;

import br.com.cardoso.mapstructcache.dto.builder.DataDtoBuilder;
import br.com.cardoso.mapstructcache.entity.builder.DataEntityBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dados")
public class DataEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;

    public DataEntity() {}

    public DataEntity(String descricao, LocalDateTime creationDate, LocalDateTime modificationDate) {
        this.descricao = descricao;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public static DataEntityBuilder builder() {
        return DataEntityBuilder.aDataEntity();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }
}
