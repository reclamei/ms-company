package br.com.reclamei.company.dataprovider.database.gateway;

import br.com.reclamei.company.core.domain.CoverageDomain;
import br.com.reclamei.company.core.gateway.CoverageGateway;
import br.com.reclamei.company.dataprovider.database.entity.CoverageEntity;
import br.com.reclamei.company.dataprovider.database.entity.LocationEntity;
import br.com.reclamei.company.dataprovider.database.entity.RelCoverageLocationEntity;
import br.com.reclamei.company.dataprovider.database.entity.RelCoverageLocationPK;
import br.com.reclamei.company.dataprovider.database.mapper.CoverageDatabaseMapper;
import br.com.reclamei.company.dataprovider.database.repository.CoverageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record CoverageGatewayImpl(CoverageDatabaseMapper mapper, CoverageRepository repository) implements CoverageGateway {

    @Override
    public void save(final CoverageDomain domain) {
        var entity = mapper.toEntity(domain);
        entity.setLocations(buildRelLocations(domain, entity));

        repository.save(entity);
    }

    private static List<RelCoverageLocationEntity> buildRelLocations(final CoverageDomain domain, final CoverageEntity entity) {
        final var coverage = new CoverageEntity(entity.getId());
        return domain.getLocations()
            .stream()
            .map(item -> new RelCoverageLocationEntity(new RelCoverageLocationPK(coverage, new LocationEntity(item.getId()))))
            .toList();
    }

}
