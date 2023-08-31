package br.com.reclamei.company.dataprovider.httpclient.mapper;

import br.com.reclamei.company.core.domain.AddressDomain;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static br.com.reclamei.company.dataprovider.httpclient.response.GeocodeResponse.AddressResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressDomain toDomain(AddressResponse response);

}
