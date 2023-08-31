package br.com.reclamei.company.dataprovider.database.repository;

import br.com.reclamei.company.dataprovider.database.entity.CoverageEntity;
import br.com.reclamei.company.dataprovider.database.entity.CoveragePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverageRepository extends JpaRepository<CoverageEntity, CoveragePK> {

}
