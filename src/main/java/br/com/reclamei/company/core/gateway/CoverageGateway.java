package br.com.reclamei.company.core.gateway;

import br.com.reclamei.company.core.domain.CoverageDomain;

import java.util.List;

public interface CoverageGateway {

    void save(CoverageDomain domain);

    void deleteById(Long serviceTypeId, Long companyId);

    List<CoverageDomain> findAll();

    CoverageDomain findById(Long serviceTypeId, Long companyId);
}
