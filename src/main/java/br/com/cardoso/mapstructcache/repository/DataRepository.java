package br.com.cardoso.mapstructcache.repository;

import br.com.cardoso.mapstructcache.entity.DataEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends CrudRepository<DataEntity, Long> {}
