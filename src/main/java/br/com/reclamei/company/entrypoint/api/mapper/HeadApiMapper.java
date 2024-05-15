package br.com.reclamei.company.entrypoint.api.mapper;

import br.com.reclamei.company.core.domain.HeadDomain;
import br.com.reclamei.company.entrypoint.api.dto.HeadCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.HeadResponse;
import br.com.reclamei.company.entrypoint.api.dto.HeadUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HeadApiMapper {
    HeadDomain toDomain(HeadCreateRequest resquest);

    HeadResponse toResponse(HeadDomain domain);

    HeadDomain toDomain(HeadUpdateRequest resquest);

    List<HeadResponse> toResponse(List<HeadDomain> domain);

}
