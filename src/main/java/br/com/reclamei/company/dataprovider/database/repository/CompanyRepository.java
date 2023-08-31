package br.com.reclamei.company.dataprovider.database.repository;

import br.com.reclamei.company.dataprovider.database.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

}
