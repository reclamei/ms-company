package br.com.reclamei.company.dataprovider.database.repository;

import br.com.reclamei.company.dataprovider.database.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

    LocationEntity findByPostcode(String postcode);

    boolean existsByPostcode(String postcode);

}
