package br.com.reclamei.company.dataprovider.database.mapper;

import br.com.reclamei.company.core.domain.CoverageDomain;
import br.com.reclamei.company.dataprovider.database.entity.CoverageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = { CompanyDatabaseMapper.class, ServiceTypeDatabaseMapper.class, RelCoverageLocationDatabaseMapper.class })
public interface CoverageDatabaseMapper {

    @Mapping(target = "locations", ignore = true)
    @Mapping(source = "serviceType", target = "id.serviceType")
    @Mapping(source = "company", target = "id.company")
    CoverageEntity toEntity(CoverageDomain domain);

    @Mapping(source = "id.serviceType", target = "serviceType")
    @Mapping(source = "id.company", target = "company")
    CoverageDomain toDomain(CoverageEntity domain);

    List<CoverageDomain> toDomain(List<CoverageEntity> domain);

}
