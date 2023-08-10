package br.com.reclamei.company.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDomain {

    private Long id;
    private String name;
    private String phone;
    private String sacPhone;
    private String email;
    private String cnpj;
    private String description;
    private List<HeadDomain> heads = new ArrayList<>();

}
