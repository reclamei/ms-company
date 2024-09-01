package br.com.reclamei.company.core.usecase;

import br.com.reclamei.company.core.domain.LocationDomain;
import br.com.reclamei.company.core.gateway.GeocodeGateway;
import br.com.reclamei.company.core.gateway.LocationGateway;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public record LocationUseCase(LocationGateway gateway, GeocodeGateway geocodeGateway) {

    public void save(final LocationDomain domain) {
        log.info("[LocationUseCase] :: create :: Creating new location. {}", domain);
        gateway.save(domain);
    }

    public void deleteById(final Long id) {
        log.info("[LocationUseCase] :: deleteById :: Deleting location with id {}", id);
        gateway.deleteById(id);
    }

    public List<LocationDomain> findAll() {
        log.info("[LocationUseCase] :: findAll :: Find all locations");
        return gateway.findAll();
    }

    public LocationDomain findByLocalization(final String latitude, final String longitude) {
        log.info("[LocationUseCase] :: findByLocalization :: Find location by [latitude: {}, longitude: {}]", latitude, longitude);
        final var address = geocodeGateway.getAddress(latitude, longitude);
        return gateway.findByLocalization(address.getPostcode());
    }

}
