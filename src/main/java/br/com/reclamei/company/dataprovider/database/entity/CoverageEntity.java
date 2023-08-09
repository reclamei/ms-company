package br.com.reclamei.company.dataprovider.database.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "coverage")
public class CoverageEntity {

    @EmbeddedId
    private CoveragePK id;

    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity company;

    @ManyToOne
    @JoinColumn(name = "service_type_id", insertable = false, updatable = false)
    private ServiceTypeEntity serviceType;

    @OneToMany(mappedBy = "coverage")
    private List<LocationEntity> locations;

}
