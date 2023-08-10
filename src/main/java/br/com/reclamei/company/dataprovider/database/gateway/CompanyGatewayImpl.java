package br.com.reclamei.company.dataprovider.database.gateway;

import br.com.reclamei.company.core.domain.CompanyDomain;
import br.com.reclamei.company.core.exception.NotFoundException;
import br.com.reclamei.company.core.gateway.CompanyGateway;
import br.com.reclamei.company.dataprovider.database.mapper.CompanyDatabaseMapper;
import br.com.reclamei.company.dataprovider.database.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public record CompanyGatewayImpl(CompanyDatabaseMapper mapper, CompanyRepository repository) implements CompanyGateway {

    @Override
    public void save(final CompanyDomain domain) {
        var entity = mapper.toEntity(domain);
        entity.getHeads().forEach(item -> item.setCompany(entity));

        repository.save(entity);
    }

    @Override
    public CompanyDomain findById(final Long id) {
        return repository.findById(id)
            .map(mapper::toDomain)
            .orElseThrow(() -> new NotFoundException(format("[CompanyGatewayImpl] :: findById :: Company with id %s not found", id)));
    }

    @Override
    public void deleteById(final Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(format("[CompanyGatewayImpl] :: deleteById :: Company with id %s not found", id));
        }
        repository.deleteById(id);
    }

}
