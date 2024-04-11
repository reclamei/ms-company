package br.com.reclamei.company.dataprovider.httpclient.gateway;

import br.com.reclamei.company.core.domain.CompanyDetailsDomain;
import br.com.reclamei.company.core.gateway.CompanyDetailsGateway;
import br.com.reclamei.company.dataprovider.httpclient.CnpjFeignClient;
import br.com.reclamei.company.dataprovider.httpclient.mapper.CompanyDetailsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;

@RequiredArgsConstructor
public class CompanyDetailsGatewayImpl implements CompanyDetailsGateway {

    private final CnpjFeignClient client;

    private final CompanyDetailsMapper mapper;

    @Override
    @Cacheable("cnpj-datails")
    public CompanyDetailsDomain getCompanyDetails(String cnpj) {
        final var response = client.getDetailsByCnpj(cnpj);
        return mapper.toDomain(response);
    }
}
