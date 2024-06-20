package com.monkilatech.backendcampasilano.service;

import java.util.List;

import com.monkilatech.backendcampasilano.model.Promotion;

public interface PromotionService {
    
    public List<Promotion> getAll() throws Exception;

    public Promotion get(long promotionId) throws Exception;

    public Promotion create(Promotion promotion) throws Exception;

    public Promotion update(Promotion promotion) throws Exception;

    public boolean delete(long promotionId) throws Exception;
    
}
