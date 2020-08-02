package br.com.cardoso.mapstructcache.mapper;

import br.com.cardoso.mapstructcache.dto.DataDto;
import br.com.cardoso.mapstructcache.entity.DataEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface DataMapper {
    DataMapper INSTANCE = Mappers.getMapper(DataMapper.class);

    @Mapping(source = "modificationDate", target = "date")
    DataDto dataToDataDto(DataEntity dataEntity);
    Set<DataDto> dataToDataDto(Iterable<DataEntity> dataEntityList);

    @Mapping(source = "date", target = "modificationDate")
    @Mapping(source = "date", target = "creationDate")
    DataEntity dataDtoToData(DataDto dataDto);
}
