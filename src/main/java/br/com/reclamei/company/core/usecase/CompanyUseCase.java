package br.com.reclamei.company.core.usecase;

import br.com.reclamei.company.core.domain.CompanyDetailsDomain;
import br.com.reclamei.company.core.domain.CompanyDomain;
import br.com.reclamei.company.core.gateway.CompanyDetailsGateway;
import br.com.reclamei.company.core.gateway.CompanyGateway;
import br.com.reclamei.company.core.gateway.HeadGateway;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
public record CompanyUseCase(CompanyGateway gateway, CompanyDetailsGateway companyDetailsGateway, HeadGateway headGateway) {

    public void save(final CompanyDomain domain) {
        log.info("[CompanyUseCase] :: create :: Creating new company. {}", domain);

        final var companyId = gateway.findIdByCnpj(domain.getCnpj());
        if(Objects.nonNull(companyId)) {
            domain.getHeads().forEach(head -> {
                    head.setIsAdmin(Boolean.TRUE);
                    head.setEmail(domain.getEmail());
                    head.setCompanyId(companyId);
                });
            domain.setId(companyId);
            headGateway.save(domain.getHeads());
        }

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

    public List<CompanyDomain> findCompaniesPendingApproval() {
        log.info("[CompanyUseCase] :: getCompaniesPendingApproval :: Find companies pending approval");
        return gateway.findCompaniesPendingApproval();
    }
}
