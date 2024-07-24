package br.com.reclamei.company.entrypoint.api.mapper;

import br.com.reclamei.company.core.domain.CompanyDetailsDomain;
import br.com.reclamei.company.core.domain.CompanyDomain;
import br.com.reclamei.company.entrypoint.api.dto.CompanyCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.CompanyResponse;
import br.com.reclamei.company.entrypoint.api.dto.CompanyUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyApiMapper {

    @Mapping(target = "id", ignore = true)
    CompanyDomain toDomain(CompanyCreateRequest resquest);

    CompanyResponse toResponse(CompanyDomain domain);

    CompanyDomain toDomain(CompanyUpdateRequest resquest);

    CompanyResponse toResponse(CompanyDetailsDomain domain);

    List<CompanyResponse> toResponse(List<CompanyDomain> companiesPendingApproval);
}
