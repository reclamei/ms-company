package br.com.reclamei.company.core.gateway;

import br.com.reclamei.company.core.domain.LocationDomain;

public interface LocationGateway {

    void save(LocationDomain domain);

    void deleteById(Long id);

}
