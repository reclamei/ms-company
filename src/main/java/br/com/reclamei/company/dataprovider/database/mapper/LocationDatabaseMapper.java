package br.com.reclamei.company.dataprovider.database.mapper;

import br.com.reclamei.company.core.domain.LocationDomain;
import br.com.reclamei.company.dataprovider.database.entity.LocationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationDatabaseMapper {

    LocationDomain toDomain(LocationEntity entity);

    LocationEntity toEntity(LocationDomain domain);

}
