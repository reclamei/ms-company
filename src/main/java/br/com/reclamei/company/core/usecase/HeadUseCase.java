package br.com.reclamei.company.core.usecase;

import br.com.reclamei.company.core.domain.HeadDomain;
import br.com.reclamei.company.core.domain.HeadStatusEnum;
import br.com.reclamei.company.core.gateway.HeadGateway;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@Slf4j
public record HeadUseCase(HeadGateway gateway) {

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

    public void updateStatus(final UUID externalId, final HeadStatusEnum status) {
        log.info("[HeadUseCase] :: updateStatus :: updating head status [external-id: {}, status: {}]", externalId, status);
        gateway.updateHeadStatus(externalId, status);
    }
}
