package br.com.reclamei.company.core.gateway;

import br.com.reclamei.company.core.domain.LocationDomain;

import java.util.List;

public interface LocationGateway {

    void save(LocationDomain domain);

    void deleteById(Long id);

    List<LocationDomain> findAll();

}
