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

import java.util.stream.Collectors;

@Service
public record CoverageGatewayImpl(CoverageDatabaseMapper mapper, CoverageRepository repository) implements CoverageGateway {

    @Override
    public void save(final CoverageDomain domain) {
        var entity = mapper.toEntity(domain);

        final var coverage = new CoverageEntity(entity.getId());
        final var locations = domain.getLocations().stream().map(item -> {
            final var pk = new RelCoverageLocationPK(coverage, new LocationEntity(item.getId()));
            return new RelCoverageLocationEntity(pk);
        }).collect(Collectors.toList());
        entity.setLocations(locations);

        repository.save(entity);
    }

}
