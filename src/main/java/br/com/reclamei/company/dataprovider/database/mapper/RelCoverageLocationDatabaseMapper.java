package br.com.reclamei.company.dataprovider.database.mapper;

import br.com.reclamei.company.core.domain.LocationDomain;
import br.com.reclamei.company.dataprovider.database.entity.RelCoverageLocationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {LocationDatabaseMapper.class})
public interface RelCoverageLocationDatabaseMapper {

    @Mapping(source = "id.location.id", target = "id")
    @Mapping(source = "id.location.name", target = "name")
    @Mapping(source = "id.location.postcode", target = "postcode")
    LocationDomain toDomain(RelCoverageLocationEntity relCoverageLocationEntity);

    List<LocationDomain> toDomainList(List<RelCoverageLocationEntity> relCoverageLocationEntities);

}
