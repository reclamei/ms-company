package br.com.reclamei.company.entrypoint.api.mapper;

import br.com.reclamei.company.core.domain.ServiceTypeDomain;
import br.com.reclamei.company.entrypoint.api.dto.ServiceTypeCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.ServiceTypeResponse;
import br.com.reclamei.company.entrypoint.api.dto.ServiceTypeUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceTypeApiMapper {

    @Mapping(target = "id", ignore = true)
    ServiceTypeDomain toDomain(ServiceTypeCreateRequest resquest);

    ServiceTypeResponse toResponse(ServiceTypeDomain domain);

    ServiceTypeDomain toDomain(ServiceTypeUpdateRequest resquest);

    List<ServiceTypeResponse> toResponse(List<ServiceTypeDomain> domain);

}
