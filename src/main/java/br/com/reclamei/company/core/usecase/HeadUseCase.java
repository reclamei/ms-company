package br.com.reclamei.company.core.usecase;

import br.com.reclamei.company.core.domain.HeadDomain;
import br.com.reclamei.company.core.domain.HeadStatusEnum;
import br.com.reclamei.company.core.gateway.HeadGateway;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

import static br.com.reclamei.company.core.domain.HeadStatusEnum.*;

@Slf4j
public record HeadUseCase(HeadGateway gateway) {

    public void confirmHead(final UUID externalId) {
        log.info("[HeadUseCase] :: confirm :: confirming head with external-id: {}", externalId);
        gateway.updateHeadStatus(externalId, CONFIRMED);
    }

    public void deleteById(final Long id) {
        log.info("[HeadUseCase] :: delete :: deleting head with id: {}", id);
        gateway.deleteById(id);
    }

    public void save(final HeadDomain domain) {
        log.info("[HeadUseCase] :: save :: saving new head. {}", domain);
        gateway.save(domain);
    }

    public List<HeadDomain> getAllHeadsByCompanyId(final Long companyId) {
        log.info("[HeadUseCase] :: getAllHeadsByCompanyId :: Find head by [company_id: {}]", companyId);
        return gateway.getAllHeadsByCompanyId(companyId);
    }

    public void denyHead(UUID externalId) {
        log.info("[HeadUseCase] :: deny :: denying registration of head with external-id: {}", externalId);
        gateway.updateHeadStatus(externalId, DENIED);
    }
}
