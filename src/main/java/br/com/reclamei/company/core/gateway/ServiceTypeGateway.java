package br.com.reclamei.company.core.gateway;

import br.com.reclamei.company.core.domain.ServiceTypeDomain;

import java.util.List;

public interface ServiceTypeGateway {

    void save(ServiceTypeDomain domain);

    ServiceTypeDomain findById(Long id);

    void deleteById(Long id);

    List<ServiceTypeDomain> findAll();

}
