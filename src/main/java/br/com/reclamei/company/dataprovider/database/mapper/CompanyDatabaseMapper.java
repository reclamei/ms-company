package br.com.reclamei.company.dataprovider.database.mapper;

import br.com.reclamei.company.core.domain.CompanyDomain;
import br.com.reclamei.company.dataprovider.database.entity.CompanyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { HeadDatabaseMapper.class })
public interface CompanyDatabaseMapper {

    CompanyDomain toDomain(CompanyEntity entity);

    CompanyEntity toEntity(CompanyDomain domain);

}
