package br.com.reclamei.company.entrypoint.api.facade;

import br.com.reclamei.company.core.usecase.HeadUseCase;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public record HeadFacade(HeadUseCase useCase) {

    public void confirmHead(final UUID externalId) {
        useCase.confirmHead(externalId);
    }

}
