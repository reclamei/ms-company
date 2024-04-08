package br.com.reclamei.company.dataprovider.httpclient.gateway;

import br.com.reclamei.company.core.domain.AddressDomain;
import br.com.reclamei.company.core.gateway.GeocodeGateway;
import br.com.reclamei.company.dataprovider.httpclient.GeocodeFeignClient;
import br.com.reclamei.company.dataprovider.httpclient.mapper.AddressMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GeocodeGatewayImpl implements GeocodeGateway {

    private final GeocodeFeignClient client;

    private final AddressMapper addressMapper;

    @Override
    public AddressDomain getAddress(final String latitude, final String longitude) {
        final var response = client.getLocalization(latitude, longitude);
        return addressMapper.toDomain(response.getAddress());
    }

}
