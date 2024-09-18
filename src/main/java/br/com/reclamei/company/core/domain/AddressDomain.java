package br.com.reclamei.company.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AddressDomain {
    private String suburb;
    private String cityDistrict;
    private String town;
    private String city;
    private String state;
    private String postcode;
}
