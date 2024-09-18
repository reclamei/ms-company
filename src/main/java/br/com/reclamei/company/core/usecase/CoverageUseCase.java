package br.com.reclamei.company.core.usecase;

import br.com.reclamei.company.core.domain.CompanyDomain;
import br.com.reclamei.company.core.domain.CoverageDomain;
import br.com.reclamei.company.core.gateway.CoverageGateway;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public record CoverageUseCase(CoverageGateway gateway) {

    public void save(final CoverageDomain domain) {
        log.info("[CoverageUseCase] :: save :: saving new coverage. {}", domain);
        gateway.save(domain);
    }

    public void deleteById(final Long serviceTypeId, final Long companyId) {
        log.info("[CoverageUseCase] :: deleteById :: deleting coverage with id [service_type_id: {}, company_id: {}]", serviceTypeId, companyId);
        gateway.deleteById(serviceTypeId, companyId);
    }

    public List<CoverageDomain> findAll() {
        log.info("[CoverageUseCase] :: findAll :: Finding all coverages");
        return gateway.findAll();
    }

    public CoverageDomain findById(final Long serviceTypeId, final Long companyId) {
        log.info("[CoverageUseCase] :: findById :: finding coverage with id [service_type_id: {}, company_id: {}]", serviceTypeId, companyId);
        return gateway.findById(serviceTypeId, companyId);
    }

    public List<CoverageDomain> findByCompanyId(final Long companyId) {
        log.info("[CoverageUseCase] :: findByCompanyId :: finding coverage with company_id: {}", companyId);
        return gateway.findByCompanyId(companyId);
    }
}
