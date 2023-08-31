package br.com.reclamei.company.dataprovider.database.mapper;

import br.com.reclamei.company.core.domain.ServiceTypeDomain;
import br.com.reclamei.company.dataprovider.database.entity.ServiceTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { ServiceSubtypeDatabaseMapper.class })
public interface ServiceTypeDatabaseMapper {

    ServiceTypeDomain toDomain(ServiceTypeEntity entity);

    ServiceTypeEntity toEntity(ServiceTypeDomain domain);

}
