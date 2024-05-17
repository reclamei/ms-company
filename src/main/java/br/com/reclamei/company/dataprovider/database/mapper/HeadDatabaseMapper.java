package br.com.reclamei.company.dataprovider.database.mapper;

import br.com.reclamei.company.core.domain.HeadDomain;
import br.com.reclamei.company.dataprovider.database.entity.HeadEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HeadDatabaseMapper {

    @Mapping(source = "company.id", target = "companyId")
    HeadDomain toDomain(HeadEntity entity);

    @Mapping(source = "companyId", target = "company.id")
    HeadEntity toEntity(HeadDomain domain);

    List<HeadDomain> toDomain(List<HeadEntity> entity);

}
