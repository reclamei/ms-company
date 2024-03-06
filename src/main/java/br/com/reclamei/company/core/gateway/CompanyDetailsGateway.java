package br.com.reclamei.company.core.gateway;

import br.com.reclamei.company.core.domain.CompanyDetailsDomain;

public interface CompanyDetailsGateway {

    CompanyDetailsDomain getCompanyDetails(final String cnpj);

}
