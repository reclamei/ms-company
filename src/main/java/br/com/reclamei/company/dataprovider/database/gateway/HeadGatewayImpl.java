package br.com.reclamei.company.dataprovider.database.gateway;

import br.com.reclamei.company.core.gateway.HeadGateway;
import br.com.reclamei.company.dataprovider.database.repository.HeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HeadGatewayImpl implements HeadGateway {

    private final HeadRepository repository;

    @Override
    @Transactional
    public void confirmHead(final UUID externalId) {
        repository.updateStatus("CONFIRMED", externalId);
    }

}
