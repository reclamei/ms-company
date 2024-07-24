package br.com.reclamei.company.dataprovider.database.gateway;

import br.com.reclamei.company.core.domain.HeadDomain;
import br.com.reclamei.company.core.domain.HeadStatusEnum;
import br.com.reclamei.company.core.exception.NotFoundException;
import br.com.reclamei.company.core.gateway.HeadGateway;
import br.com.reclamei.company.dataprovider.database.mapper.HeadDatabaseMapper;
import br.com.reclamei.company.dataprovider.database.repository.HeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static br.com.reclamei.company.core.domain.HeadStatusEnum.CONFIRMED;

@Service
@RequiredArgsConstructor
public class HeadGatewayImpl implements HeadGateway {

    private final HeadRepository repository;

    private final HeadDatabaseMapper mapper;

    @Override
    @Transactional
    public void updateHeadStatus(final UUID externalId, final HeadStatusEnum status) {
        repository.updateStatus(status, externalId);
    }

    @Override
    public void deleteById(final Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(String.format("[HeadGatewayImpl] :: deleteById :: Head with id %s not found", id));
        }
        repository.deleteById(id);
    }

    @Override
    public void save(final HeadDomain domain) {
        var entity = mapper.toEntity(domain);
        repository.save(entity);
    }

    @Override
    public List<HeadDomain> getAllHeadsByCompanyId(final Long companyId) {
        return mapper.toDomain(repository.findAllByCompanyId(companyId));
    }

}
