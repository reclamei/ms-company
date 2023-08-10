package br.com.reclamei.company.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ServiceTypeDomain {

    private Long id;
    private String name;
    private String description;
    private List<ServiceSubtypeDomain> subtypes = new ArrayList<>();

}
