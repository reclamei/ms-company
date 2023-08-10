package br.com.reclamei.company.entrypoint.api.facade;

import br.com.reclamei.company.core.usecase.CompanyUseCase;
import br.com.reclamei.company.entrypoint.api.dto.CompanyCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.CompanyResponse;
import br.com.reclamei.company.entrypoint.api.dto.CompanyUpdateRequest;
import br.com.reclamei.company.entrypoint.api.mapper.CompanyApiMapper;
import org.springframework.stereotype.Component;

@Component
public record CompanyFacade(CompanyApiMapper mapper, CompanyUseCase useCase) {

    public void create(final CompanyCreateRequest request) {
        var domain = mapper.toDomain(request);
        useCase.save(domain);
    }

    public void update(final CompanyUpdateRequest request) {
        var domain = mapper.toDomain(request);
        useCase.save(domain);
    }

    public CompanyResponse findById(final Long id) {
        var domain = useCase.findById(id);
        return mapper.toResponse(domain);
    }

    public void deleteById(final Long id) {
        useCase.deleteById(id);
    }
}
