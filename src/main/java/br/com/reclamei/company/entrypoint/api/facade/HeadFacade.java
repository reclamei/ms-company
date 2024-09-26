package br.com.reclamei.company.entrypoint.api.facade;

import br.com.reclamei.company.core.domain.HeadStatusEnum;
import br.com.reclamei.company.core.usecase.HeadUseCase;
import br.com.reclamei.company.entrypoint.api.dto.HeadCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.HeadResponse;
import br.com.reclamei.company.entrypoint.api.dto.HeadUpdateRequest;
import br.com.reclamei.company.entrypoint.api.mapper.HeadApiMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static br.com.reclamei.company.core.domain.HeadStatusEnum.*;

@Component
public record HeadFacade(HeadApiMapper mapper, HeadUseCase useCase) {

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
        useCase.updateStatus(externalId, DENIED);
    }

    public void confirmHead(final UUID externalId) {
        useCase.updateStatus(externalId, CONFIRMED);
    }

    public void approveHead(final UUID externalId) {
        useCase.updateStatus(externalId, PENDING_CONFIRMATION);
    }

    public void requestApproval(final UUID externalId) {
        useCase.updateStatus(externalId, PENDING_APPROVAL);
    }
}
