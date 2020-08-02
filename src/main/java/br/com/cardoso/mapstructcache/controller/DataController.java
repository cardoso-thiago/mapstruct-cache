package br.com.cardoso.mapstructcache.controller;

import br.com.cardoso.mapstructcache.dto.DataDto;
import br.com.cardoso.mapstructcache.entity.DataEntity;
import br.com.cardoso.mapstructcache.mapper.DataMapper;
import br.com.cardoso.mapstructcache.repository.DataRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@CacheConfig(cacheNames="cacheData")
public class DataController {

    private final Logger log = Logger.getGlobal();
    private final DataRepository dataRepository;

    public DataController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @GetMapping
    @Cacheable(value = "getAll")
    public ResponseEntity<?> getData(){
        log.info("Recuperando as informações com conversão");
        return ResponseEntity.ok(DataMapper.INSTANCE.dataToDataDto(dataRepository.findAll()));
    }

    @PostMapping
    @CacheEvict(value = {"getAll", "getAllDb"}, allEntries = true)
    public ResponseEntity<?> save(@RequestBody DataDto dataDto){
        log.info("Salvando data");
        DataEntity dataEntity = DataMapper.INSTANCE.dataDtoToData(dataDto);
        DataEntity savedDataEntity = dataRepository.save(dataEntity);
        return ResponseEntity.ok(DataMapper.INSTANCE.dataToDataDto(savedDataEntity));
    }

    @GetMapping("/db")
    @Cacheable(value = "getAllDb")
    public ResponseEntity<?> getDataFromDb(){
        log.info("Recuperando as informações sem conversão");
        return ResponseEntity.ok(dataRepository.findAll());
    }

}
