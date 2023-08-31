package br.com.reclamei.company.core.usecase;

import br.com.reclamei.company.core.domain.CoverageDomain;
import br.com.reclamei.company.core.gateway.CoverageGateway;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record CoverageUseCase(CoverageGateway gateway) {

    public void save(final CoverageDomain domain) {
        log.info("[CoverageUseCase] :: create :: Creating new coverage. {}", domain);
        gateway.save(domain);
    }

}
