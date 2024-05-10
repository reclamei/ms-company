package br.com.reclamei.company.core.usecase;

import br.com.reclamei.company.core.gateway.CompanyGateway;
import br.com.reclamei.company.core.gateway.HeadGateway;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public record HeadUseCase(HeadGateway gateway) {

    public void confirmHead(final UUID externalId) {
        log.info("[HeadUseCase] :: confirm :: confirming head with external-id: {}", externalId);
        gateway.confirmHead(externalId);
    }

}
