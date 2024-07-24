package br.com.reclamei.company.entrypoint.api.facade;

import br.com.reclamei.company.core.usecase.HeadUseCase;
import br.com.reclamei.company.entrypoint.api.dto.HeadCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.HeadResponse;
import br.com.reclamei.company.entrypoint.api.dto.HeadUpdateRequest;
import br.com.reclamei.company.entrypoint.api.mapper.HeadApiMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public record HeadFacade(HeadApiMapper mapper, HeadUseCase useCase) {

    public void confirmHead(final UUID externalId) {
        useCase.confirmHead(externalId);
    }

    public void create(final HeadCreateRequest request) {
        var domain = mapper.toDomain(request);
        useCase.save(domain);
    }

    public void deleteById(final Long id) {
        useCase.deleteById(id);
    }

    public void update(final HeadUpdateRequest request) {
        var domain = mapper.toDomain(request);
        useCase.save(domain);
    }

    public List<HeadResponse> getAllHeadsByCompanyId(final Long companyId) {
        return mapper.toResponse(useCase.getAllHeadsByCompanyId(companyId));
    }

    public void denyHead(final UUID externalId) {
        useCase.denyHead(externalId);
    }
}
