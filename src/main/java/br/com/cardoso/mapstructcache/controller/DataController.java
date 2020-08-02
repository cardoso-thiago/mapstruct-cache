package br.com.cardoso.mapstructcache.controller;

import br.com.cardoso.mapstructcache.dto.DataDto;
import br.com.cardoso.mapstructcache.entity.DataEntity;
import br.com.cardoso.mapstructcache.mapper.DataMapper;
import br.com.cardoso.mapstructcache.repository.DataRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.logging.Logger;

@RestController
@CacheConfig(cacheNames = "cacheData")
@Validated
public class DataController {

    private final Logger log = Logger.getGlobal();
    private final DataRepository dataRepository;

    public DataController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @GetMapping
    @Cacheable(value = "getAll")
    public ResponseEntity<?> getData() {
        log.info("Recuperando as informações com conversão");
        return ResponseEntity.ok(DataMapper.INSTANCE.dataToDataDto(dataRepository.findAll()));
    }

    @PostMapping
    @CacheEvict(value = {"getAll", "getAllDb"}, allEntries = true)
    public ResponseEntity<?> save(@Validated @RequestBody DataDto dataDto) {
        log.info("Salvando data");
        DataEntity dataEntity = DataMapper.INSTANCE.dataDtoToData(dataDto);
        DataEntity savedDataEntity = dataRepository.save(dataEntity);
        return ResponseEntity.ok(DataMapper.INSTANCE.dataToDataDto(savedDataEntity));
    }

    @PostMapping("/{numero_aleatorio}")
    public ResponseEntity<?> save(
            @NotNull(message = "O valor não pode ser nulo")
            @Min(value = 1L, message = "O valor deve ser um número positivo")
            @Max(value = Integer.MAX_VALUE, message = "Ultrapassou o valor máximo permitido")
            @Pattern(regexp = "\\d+", message = "O valor deve ser numérico")
            @PathVariable(value = "numero_aleatorio") Long numeroAleatorio) {
        return ResponseEntity.ok(numeroAleatorio);
    }

    @GetMapping("/db")
    @Cacheable(value = "getAllDb")
    public ResponseEntity<?> getDataFromDb() {
        log.info("Recuperando as informações sem conversão");
        return ResponseEntity.ok(dataRepository.findAll());
    }

}
