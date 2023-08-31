package br.com.reclamei.company.dataprovider.database.mapper;

import br.com.reclamei.company.core.domain.ServiceSubtypeDomain;
import br.com.reclamei.company.dataprovider.database.entity.ServiceSubtypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceSubtypeDatabaseMapper {

    ServiceSubtypeDomain toDomain(ServiceSubtypeEntity entity);

    ServiceSubtypeEntity toEntity(ServiceSubtypeDomain domain);

}
