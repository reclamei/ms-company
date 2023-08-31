package br.com.reclamei.company.entrypoint.api.facade;

import br.com.reclamei.company.core.usecase.CoverageUseCase;
import br.com.reclamei.company.entrypoint.api.dto.CoverageCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.CoverageUpdateRequest;
import br.com.reclamei.company.entrypoint.api.mapper.CoverageApiMapper;
import org.springframework.stereotype.Component;

@Component
public record CoverageFacade(CoverageApiMapper mapper, CoverageUseCase useCase) {

    public void create(final CoverageCreateRequest request) {
        var domain = mapper.toDomain(request);
        useCase.save(domain);
    }

    public void update(final CoverageUpdateRequest request) {
        var domain = mapper.toDomain(request);
        useCase.save(domain);
    }

}
