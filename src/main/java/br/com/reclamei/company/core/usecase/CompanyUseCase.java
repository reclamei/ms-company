package br.com.reclamei.company.core.usecase;

import br.com.reclamei.company.core.domain.CompanyDomain;
import br.com.reclamei.company.core.gateway.CompanyGateway;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record CompanyUseCase(CompanyGateway gateway) {

    public void save(final CompanyDomain domain) {
        log.info("[CompanyUseCase] :: create :: Creating new company. {}", domain);
        gateway.save(domain);
    }

    public CompanyDomain findById(final Long id) {
        log.info("[CompanyUseCase] :: findById :: Finding company with id {}", id);
        return gateway.findById(id);
    }

    public void deleteById(final Long id) {
        log.info("[CompanyUseCase] :: deleteById :: Deleting company with id {}", id);
        gateway.deleteById(id);
    }
}
