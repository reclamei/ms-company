package br.com.reclamei.company.dataprovider.database.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "coverage")
public class CoverageEntity {

    @EmbeddedId
    private CoveragePK id;

    @OneToMany(mappedBy = "id.coverage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RelCoverageLocationEntity> locations = new ArrayList<>();

    public CoverageEntity(final CoveragePK id) {
        this.id = id;
    }

}
