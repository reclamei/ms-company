package br.com.reclamei.company.entrypoint.api.mapper;

import br.com.reclamei.company.core.domain.LocationDomain;
import br.com.reclamei.company.entrypoint.api.dto.LocationCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.LocationResponse;
import br.com.reclamei.company.entrypoint.api.dto.LocationUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationApiMapper {

    @Mapping(target = "id", ignore = true)
    LocationDomain toDomain(LocationCreateRequest resquest);

    LocationResponse toResponse(LocationDomain domain);

    LocationDomain toDomain(LocationUpdateRequest resquest);

    List<LocationResponse> toResponse(List<LocationDomain> domain);
}
