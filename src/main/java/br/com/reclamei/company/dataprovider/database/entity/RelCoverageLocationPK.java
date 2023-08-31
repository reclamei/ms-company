package br.com.reclamei.company.dataprovider.database.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class RelCoverageLocationPK implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns(value = {
        @JoinColumn(name = "coverage_company_id", referencedColumnName = "company_id"),
        @JoinColumn(name = "coverage_service_type_id", referencedColumnName = "service_type_id")
    })
    private CoverageEntity coverage;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", insertable = false, updatable = false)
    private LocationEntity location;

}
