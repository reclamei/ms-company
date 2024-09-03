package br.com.reclamei.company.entrypoint.api.facade;

import br.com.reclamei.company.core.usecase.CoverageUseCase;
import br.com.reclamei.company.entrypoint.api.dto.CoverageCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.CoverageResponse;
import br.com.reclamei.company.entrypoint.api.dto.CoverageUpdateRequest;
import br.com.reclamei.company.entrypoint.api.mapper.CoverageApiMapper;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public void deleteById(final Long serviceTypeId, final Long companyId) {
        useCase.deleteById(serviceTypeId, companyId);
    }

    public List<CoverageResponse> findAll() {
        var domainList = useCase.findAll();
        return mapper.toResponse(domainList);
    }

    public CoverageResponse findById(final Long serviceTypeId, final Long companyId) {
        var domain = useCase.findById(serviceTypeId, companyId);
        return mapper.toResponse(domain);
    }

    public List<CoverageResponse> findByCompanyId(Long companyId) {
        var domain = useCase.findByCompanyId(companyId);
        return mapper.toResponse(domain);
    }
}
