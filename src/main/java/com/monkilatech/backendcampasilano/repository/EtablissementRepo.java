package com.monkilatech.backendcampasilano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.monkilatech.backendcampasilano.model.Etablissement;

@Repository
public interface EtablissementRepo extends JpaRepository<Etablissement, Long> {

    @Query("FROM Etablissement e WHERE e.id=:etablissementId")
    public Etablissement getEtablissementById(@Param("etablissementId") long etablissementId);

}
