package br.com.reclamei.company.dataprovider.database.repository;

import br.com.reclamei.company.dataprovider.database.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

    @Query("SELECT c FROM HeadEntity h INNER JOIN CompanyEntity c ON h.company.id = c.id WHERE h.externalId = :externalId")
    CompanyEntity findByHeadExternalId(final UUID externalId);

}
