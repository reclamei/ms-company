package br.com.reclamei.company.core.usecase;

import br.com.reclamei.company.core.domain.ServiceTypeDomain;
import br.com.reclamei.company.core.gateway.ServiceTypeGateway;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record ServiceTypeUseCase(ServiceTypeGateway gateway) {

    public void save(final ServiceTypeDomain domain) {
        log.info("[ServiceTypeUseCase] :: create :: Creating new service type. {}", domain);
        gateway.save(domain);
    }

    public ServiceTypeDomain findById(final Long id) {
        log.info("[ServiceTypeUseCase] :: findById :: Finding service type with id {}", id);
        return gateway.findById(id);
    }

    public void deleteCitizenById(final Long id) {
        log.info("[ServiceTypeUseCase] :: deleteCitizenById :: Deleting service type with id {}", id);
        gateway.deleteById(id);
    }
}
