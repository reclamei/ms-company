package br.com.reclamei.company.core.gateway;

import br.com.reclamei.company.core.domain.AddressDomain;

public interface GeocodeGateway {
    AddressDomain getAddress(final String latitude, final String longitude);
}
