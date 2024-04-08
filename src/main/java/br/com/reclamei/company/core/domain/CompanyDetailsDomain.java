package br.com.reclamei.company.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CompanyDetailsDomain {
    private String name;
    private String cnpj;
    private String email;
    private String description;
}
