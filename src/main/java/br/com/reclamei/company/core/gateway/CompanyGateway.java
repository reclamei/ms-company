package br.com.reclamei.company.core.gateway;

import br.com.reclamei.company.core.domain.CompanyDomain;

import java.util.UUID;

public interface CompanyGateway {

    void save(CompanyDomain domain);

    CompanyDomain findById(Long id);

    void deleteById(Long id);

    CompanyDomain getCompanyByHeadExternalId(UUID externalId);
}
