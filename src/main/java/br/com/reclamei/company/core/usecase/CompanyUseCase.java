package br.com.reclamei.company.core.usecase;

import br.com.reclamei.company.core.domain.CompanyDetailsDomain;
import br.com.reclamei.company.core.domain.CompanyDomain;
import br.com.reclamei.company.core.gateway.CompanyDetailsGateway;
import br.com.reclamei.company.core.gateway.CompanyGateway;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public record CompanyUseCase(CompanyGateway gateway, CompanyDetailsGateway companyDetailsGateway) {

    public void save(final CompanyDomain domain) {
        log.info("[CompanyUseCase] :: create :: Creating new company. {}", domain);
        domain.getHeads().stream().findFirst()
            .ifPresent(head -> {
                head.setIsAdmin(Boolean.TRUE);
                head.setEmail(domain.getEmail());
            });
        gateway.save(domain);
    }

    public void update(final CompanyDomain domain) {
        log.info("[CompanyUseCase] :: update :: Updating company. {}", domain);
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

    public CompanyDetailsDomain getCompanyDetailsByCnpj(final String cnpj) {
        log.info("[CompanyUseCase] :: getCompanyDetailsByCnpj :: Find company details by [cnpj: {}]", cnpj);
        return companyDetailsGateway.getCompanyDetails(cnpj);
    }

    public CompanyDomain getCompanyByHeadExternalId(final UUID externalId) {
        log.info("[CompanyUseCase] :: getCompanyByHeadExternalId :: Find company details by head [external-id: {}]", externalId);
        return gateway.getCompanyByHeadExternalId(externalId);
    }
}
