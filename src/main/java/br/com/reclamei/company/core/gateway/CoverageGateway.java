package br.com.reclamei.company.core.gateway;

import br.com.reclamei.company.core.domain.CoverageDomain;

public interface CoverageGateway {

    void save(CoverageDomain domain);

    void deleteById(Long serviceTypeId, Long companyId);

}
