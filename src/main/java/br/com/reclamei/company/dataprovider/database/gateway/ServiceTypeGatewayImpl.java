package br.com.reclamei.company.dataprovider.database.gateway;

import br.com.reclamei.company.core.domain.ServiceTypeDomain;
import br.com.reclamei.company.core.exception.NotFoundException;
import br.com.reclamei.company.core.gateway.ServiceTypeGateway;
import br.com.reclamei.company.dataprovider.database.mapper.ServiceTypeDatabaseMapper;
import br.com.reclamei.company.dataprovider.database.repository.ServiceTypeRepository;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public record ServiceTypeGatewayImpl(ServiceTypeDatabaseMapper mapper, ServiceTypeRepository repository) implements ServiceTypeGateway {

    @Override
    public void save(final ServiceTypeDomain domain) {
        var entity = mapper.toEntity(domain);
        entity.getSubtypes().forEach(item -> item.setServiceType(entity));

        repository.save(entity);
    }

    @Override
    public ServiceTypeDomain findById(final Long id) {
        return repository.findById(id)
            .map(mapper::toDomain)
            .orElseThrow(() -> new NotFoundException(format("[ServiceTypeGatewayImpl] :: findById :: Service type with id %s not found", id)));
    }

    @Override
    public void deleteById(final Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(format("[ServiceTypeGatewayImpl] :: deleteById :: Service type with id %s not found", id));
        }
        repository.deleteById(id);
    }

}
