package br.com.reclamei.company.entrypoint.api.facade;

import br.com.reclamei.company.core.usecase.ServiceTypeUseCase;
import br.com.reclamei.company.entrypoint.api.dto.ServiceTypeCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.ServiceTypeResponse;
import br.com.reclamei.company.entrypoint.api.dto.ServiceTypeUpdateRequest;
import br.com.reclamei.company.entrypoint.api.mapper.ServiceTypeApiMapper;
import org.springframework.stereotype.Component;

@Component
public record ServiceTypeFacade(ServiceTypeApiMapper mapper, ServiceTypeUseCase useCase) {

    public void create(final ServiceTypeCreateRequest request) {
        var domain = mapper.toDomain(request);
        useCase.save(domain);
    }

    public void update(final ServiceTypeUpdateRequest request) {
        var domain = mapper.toDomain(request);
        useCase.save(domain);
    }

    public ServiceTypeResponse findById(final Long id) {
        var domain = useCase.findById(id);
        return mapper.toResponse(domain);
    }

    public void deleteById(final Long id) {
        useCase.deleteById(id);
    }

}
