package br.com.reclamei.company.dataprovider.database.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Embeddable
@NoArgsConstructor
public class CoveragePK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity company;

    @ManyToOne
    @JoinColumn(name = "service_type_id", insertable = false, updatable = false)
    private ServiceTypeEntity serviceType;

    public CoveragePK(Long company, Long serviceType) {
        this.company = new CompanyEntity(company);
        this.serviceType = new ServiceTypeEntity(serviceType);
    }
}
