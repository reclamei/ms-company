package br.com.reclamei.company.dataprovider.database.gateway;

import br.com.reclamei.company.core.domain.LocationDomain;
import br.com.reclamei.company.core.exception.NotFoundException;
import br.com.reclamei.company.core.gateway.LocationGateway;
import br.com.reclamei.company.dataprovider.database.mapper.LocationDatabaseMapper;
import br.com.reclamei.company.dataprovider.database.repository.LocationRepository;
import org.springframework.stereotype.Service;

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

}