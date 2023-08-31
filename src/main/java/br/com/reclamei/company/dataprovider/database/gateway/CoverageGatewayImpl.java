package br.com.reclamei.company.dataprovider.database.gateway;

import br.com.reclamei.company.core.domain.CoverageDomain;
import br.com.reclamei.company.core.exception.NotFoundException;
import br.com.reclamei.company.core.gateway.CoverageGateway;
import br.com.reclamei.company.dataprovider.database.entity.CoverageEntity;
import br.com.reclamei.company.dataprovider.database.entity.LocationEntity;
import br.com.reclamei.company.dataprovider.database.entity.RelCoverageLocationEntity;
import br.com.reclamei.company.dataprovider.database.entity.RelCoverageLocationPK;
import br.com.reclamei.company.dataprovider.database.mapper.CoverageDatabaseMapper;
import br.com.reclamei.company.dataprovider.database.repository.CoverageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoverageGatewayImpl implements CoverageGateway {

    private final CoverageDatabaseMapper mapper;
    private final CoverageRepository repository;

    @Override
    public void save(final CoverageDomain domain) {
        var entity = mapper.toEntity(domain);
        entity.setLocations(buildRelLocations(domain, entity));

        repository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(final Long serviceTypeId, final Long companyId) {
        if (!repository.existsByIdServiceTypeIdAndIdCompanyId(serviceTypeId, companyId)) {
            throw new NotFoundException(String.format(
                "[CompanyGatewayImpl] :: deleteById :: Company with id [service_type_id: %s, company_id: %s] not found", serviceTypeId, companyId));
        }
        repository.deleteByIdServiceTypeIdAndIdCompanyId(serviceTypeId, companyId);
    }

    private static List<RelCoverageLocationEntity> buildRelLocations(final CoverageDomain domain, final CoverageEntity entity) {
        final var coverage = new CoverageEntity(entity.getId());
        return domain.getLocations()
            .stream()
            .map(item -> new RelCoverageLocationEntity(new RelCoverageLocationPK(coverage, new LocationEntity(item.getId()))))
            .toList();
    }

}
