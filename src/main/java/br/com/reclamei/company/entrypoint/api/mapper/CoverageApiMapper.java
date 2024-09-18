package br.com.reclamei.company.entrypoint.api.mapper;

import br.com.reclamei.company.core.domain.CoverageDomain;
import br.com.reclamei.company.entrypoint.api.dto.CoverageCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.CoverageResponse;
import br.com.reclamei.company.entrypoint.api.dto.CoverageUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CoverageApiMapper {

    CoverageDomain toDomain(CoverageCreateRequest resquest);

    CoverageDomain toDomain(CoverageUpdateRequest resquest);

    CoverageResponse toResponse(CoverageDomain resquest);

    List<CoverageResponse> toResponse(List<CoverageDomain> resquest);
}
