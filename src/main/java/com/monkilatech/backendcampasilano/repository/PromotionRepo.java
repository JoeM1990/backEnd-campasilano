package com.monkilatech.backendcampasilano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.monkilatech.backendcampasilano.model.Promotion;

@Repository
public interface PromotionRepo extends JpaRepository<Promotion, Long> {
    @Query("FROM promotion s WHERE s.id=:promotionId")
    public Promotion getPromotionById(@Param("promotionId") long promotionId);
}
