package com.monkilatech.backendcampasilano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.monkilatech.backendcampasilano.model.Demandes;

@Repository
public interface DemandesRepo extends JpaRepository<Demandes, Long> {

    @Query("FROM demandes s WHERE s.id=:demandeId")
    public Demandes getDemandeById(@Param("demandeId") long demandeId);

    @Query("FROM demandes s WHERE s.fromUid=:fromUid AND s.senderUid=:senderUid AND s.content=:content")
    public Demandes getDemandeChats(@Param("fromUid") String fromUid, @Param("senderUid") String senderUid,
            @Param("content") String content);

}
