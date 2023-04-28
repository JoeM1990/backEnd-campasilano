package com.monkilatech.backendcampasilano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monkilatech.backendcampasilano.model.Promotion;
import com.monkilatech.backendcampasilano.repository.PromotionRepo;
import com.monkilatech.backendcampasilano.utils.ValueException;

@Service
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    private PromotionRepo promotionRepo;

    @Override
    public List<Promotion> getAll() throws Exception {
        List<Promotion> promotions = this.promotionRepo.findAll();

        return promotions;
    }

    @Override
    public Promotion get(long promotionId) throws Exception {

        return this.promotionRepo.getPromotionById(promotionId);
    }

    @Override
    public Promotion create(Promotion promotion) throws Exception {

        return this.promotionRepo.save(promotion);
    }

    @Override
    public Promotion update(Promotion promotion) throws Exception {

        return this.promotionRepo.save(promotion);
    }

    @Override
    public boolean delete(long promotionId) throws Exception {

        Promotion promotion = this.promotionRepo.getPromotionById(promotionId);
        if (promotion == null)
            throw new ValueException("Aucune Promotion n'est trouvé avec l'id " + promotionId);

        this.promotionRepo.delete(promotion);

        Promotion PromotionCheckOut = this.promotionRepo.getPromotionById(promotionId);

        if (PromotionCheckOut != null)
            return true;
        return false;
    }
}
