package br.com.reclamei.company.entrypoint.api.facade;

import br.com.reclamei.company.core.usecase.LocationUseCase;
import br.com.reclamei.company.entrypoint.api.dto.LocationCreateRequest;
import br.com.reclamei.company.entrypoint.api.dto.LocationResponse;
import br.com.reclamei.company.entrypoint.api.dto.LocationUpdateRequest;
import br.com.reclamei.company.entrypoint.api.mapper.LocationApiMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public record LocationFacade(LocationApiMapper mapper, LocationUseCase useCase) {

    public void create(final LocationCreateRequest request) {
        var domain = mapper.toDomain(request);
        useCase.save(domain);
    }

    public void update(final LocationUpdateRequest request) {
        var domain = mapper.toDomain(request);
        useCase.save(domain);
    }

    public void deleteById(final Long id) {
        useCase.deleteById(id);
    }

    public List<LocationResponse> findAll() {
        return mapper.toResponse(useCase.findAll());
    }

}
