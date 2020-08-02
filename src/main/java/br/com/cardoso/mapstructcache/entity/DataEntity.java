package br.com.cardoso.mapstructcache.entity;

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
    private Long numeroAleatorio;

    public DataEntity() {
    }

    public DataEntity(String descricao, LocalDateTime creationDate, LocalDateTime modificationDate, Long numeroAleatorio) {
        this.descricao = descricao;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.numeroAleatorio = numeroAleatorio;
    }

    //Necessário para o MapStruct
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

    public Long getNumeroAleatorio() {
        return numeroAleatorio;
    }
}
