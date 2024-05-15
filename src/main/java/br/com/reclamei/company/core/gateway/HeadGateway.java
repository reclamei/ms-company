package br.com.reclamei.company.core.gateway;

import br.com.reclamei.company.core.domain.HeadDomain;

import java.util.List;
import java.util.UUID;

public interface HeadGateway {

    void confirmHead(UUID externalId);

    void deleteById(Long id);

    void save(HeadDomain domain);

    List<HeadDomain> getAllHeadsByCompanyId(Long companyId);
}
