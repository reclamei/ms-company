package br.com.reclamei.company.dataprovider.database.gateway;

import br.com.reclamei.company.core.domain.CompanyDomain;
import br.com.reclamei.company.core.exception.NotFoundException;
import br.com.reclamei.company.core.gateway.CompanyGateway;
import br.com.reclamei.company.dataprovider.database.entity.CompanyEntity;
import br.com.reclamei.company.dataprovider.database.mapper.CompanyDatabaseMapper;
import br.com.reclamei.company.dataprovider.database.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CompanyGatewayImpl implements CompanyGateway {

    private final CompanyDatabaseMapper mapper;
    private final CompanyRepository repository;

    @Override
    public CompanyDomain save(final CompanyDomain domain) {
        var entity = mapper.toEntity(domain);
        return mapper.toDomain(repository.saveAndFlush(entity));
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

    @Override
    @Transactional
    public CompanyDomain getCompanyByHeadExternalId(final UUID externalId) {
        final var company = repository.findByHeadExternalId(externalId);

        if (Objects.isNull(company)) {
            throw new NotFoundException(format("[CompanyGatewayImpl] :: getCompanyByHeadExternalId :: Company with head.external-id %s not found", externalId));
        }
        return mapper.toDomain(company);
    }

    @Override
    @Transactional
    public List<CompanyDomain> findCompaniesPendingApproval() {
        return mapper.toDomain(repository.findCompaniesPendingApproval());
    }

    @Override
    public Long findIdByCnpj(final String cnpj) {
        final var company = repository.findByCnpj(cnpj);
        return company.map(CompanyEntity::getId).orElse(null);
    }

    @Override
    @Transactional
    public List<CompanyDomain> findAll() {
        return mapper.toDomain(repository.findAll());
    }

}
