package br.com.reclamei.company.dataprovider.database.mapper;

import br.com.reclamei.company.core.domain.HeadDomain;
import br.com.reclamei.company.dataprovider.database.entity.HeadEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HeadDatabaseMapper {

    HeadDomain toDomain(HeadEntity entity);

    HeadEntity toEntity(HeadDomain domain);

}
