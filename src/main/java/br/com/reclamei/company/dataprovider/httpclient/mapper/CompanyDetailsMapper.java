package br.com.reclamei.company.dataprovider.httpclient.mapper;

import br.com.reclamei.company.core.domain.CompanyDetailsDomain;
import br.com.reclamei.company.dataprovider.httpclient.response.CompanyDetailsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyDetailsMapper {

    @Mapping(source = "socialReason", target = "name")
    @Mapping(source = "commercialPlace.cnpj", target = "cnpj")
    @Mapping(source = "commercialPlace.email", target = "email")
    @Mapping(source = "commercialPlace.mainActivity.description", target = "description")
    @Mapping(target = "phone", source = "response", qualifiedByName = "concatPhone")
    CompanyDetailsDomain toDomain(CompanyDetailsResponse response);

    @Named("concatPhone")
    default String concatPhone(CompanyDetailsResponse source) {
        return source.getCommercialPlace().getDdd() + " " + source.getCommercialPlace().getPhone();
    }

}
