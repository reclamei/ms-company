package br.com.reclamei.company.core.gateway;

import br.com.reclamei.company.core.domain.HeadDomain;
import br.com.reclamei.company.core.domain.HeadStatusEnum;

import java.util.List;
import java.util.UUID;

public interface HeadGateway {

    void updateHeadStatus(UUID externalId, HeadStatusEnum status);

    void deleteById(Long id);

    void save(HeadDomain domain);

    void save(List<HeadDomain> domain);

    List<HeadDomain> getAllHeadsByCompanyId(Long companyId);
}
