package br.com.reclamei.company.dataprovider.database.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rel_coverage_location")
public class RelCoverageLocationEntity {

    @EmbeddedId
    private RelCoverageLocationPK id;

}
