package br.com.reclamei.company.core.gateway;

import br.com.reclamei.company.core.domain.ServiceTypeDomain;

public interface ServiceTypeGateway {

    void save(ServiceTypeDomain domain);

    ServiceTypeDomain findById(Long id);

    void deleteById(Long id);

}
