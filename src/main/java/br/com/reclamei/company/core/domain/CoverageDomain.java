package br.com.reclamei.company.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CoverageDomain {

    private ServiceTypeDomain serviceType;
    private CompanyDomain company;
    private List<LocationDomain> locations = new ArrayList<>();
}
