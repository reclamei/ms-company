package br.com.reclamei.company.dataprovider.database.gateway;

import br.com.reclamei.company.core.domain.LocationDomain;
import br.com.reclamei.company.core.exception.NotFoundException;
import br.com.reclamei.company.core.gateway.LocationGateway;
import br.com.reclamei.company.dataprovider.database.mapper.LocationDatabaseMapper;
import br.com.reclamei.company.dataprovider.database.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
public record LocationGatewayImpl(LocationDatabaseMapper mapper, LocationRepository repository) implements LocationGateway {

    @Override
    public void save(final LocationDomain domain) {
        var entity = mapper.toEntity(domain);
        repository.save(entity);
    }

    @Override
    public void deleteById(final Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(format("[LocationGatewayImpl] :: deleteById :: Location with id %s not found", id));
        }
        repository.deleteById(id);
    }

    @Override
    public List<LocationDomain> findAll() {
        return mapper.toDomain(repository.findAll());
    }

    @Override
    public LocationDomain findByLocalization(final String postcode) {
        if (!repository.existsByPostcode(postcode)) {
            throw new NotFoundException(format("[LocationGatewayImpl] :: findByLocalization :: Location with postcode %s not found", postcode));
        }
        return mapper.toDomain(repository.findByPostcode(postcode));
    }

}
