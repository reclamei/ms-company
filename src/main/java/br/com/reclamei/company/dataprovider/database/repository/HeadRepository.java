package br.com.reclamei.company.dataprovider.database.repository;

import br.com.reclamei.company.dataprovider.database.entity.HeadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface HeadRepository extends JpaRepository<HeadEntity, Long> {

    @Modifying
    @Query("UPDATE HeadEntity SET status = :status WHERE externalId = :externalId")
    void updateStatus(final String status, final UUID externalId);

}
