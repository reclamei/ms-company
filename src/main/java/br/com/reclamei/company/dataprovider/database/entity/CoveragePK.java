package br.com.reclamei.company.dataprovider.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CoveragePK implements Serializable {

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "service_type_id")
    private Long serviceTypeId;

}
