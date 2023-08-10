package br.com.reclamei.company.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeadDomain {

    private Long id;
    private String email;
    private String name;
    private String phone;

}
