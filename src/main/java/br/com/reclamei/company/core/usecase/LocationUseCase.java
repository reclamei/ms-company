package br.com.reclamei.company.core.usecase;

import br.com.reclamei.company.core.domain.LocationDomain;
import br.com.reclamei.company.core.gateway.LocationGateway;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record LocationUseCase(LocationGateway gateway) {

    public void save(final LocationDomain domain) {
        log.info("[LocationUseCase] :: create :: Creating new location. {}", domain);
        gateway.save(domain);
    }

    public void deleteById(final Long id) {
        log.info("[LocationUseCase] :: deleteById :: Deleting location with id {}", id);
        gateway.deleteById(id);
    }

}
