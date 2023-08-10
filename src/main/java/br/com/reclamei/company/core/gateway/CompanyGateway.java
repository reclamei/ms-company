package br.com.reclamei.company.core.gateway;

import br.com.reclamei.company.core.domain.CompanyDomain;

public interface CompanyGateway {

    void save(CompanyDomain domain);

    CompanyDomain findById(Long id);

    void deleteById(Long id);

}
