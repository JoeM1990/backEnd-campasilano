package com.monkilatech.backendcampasilano.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.monkilatech.backendcampasilano.model.Demandes;
import com.monkilatech.backendcampasilano.repository.DemandesRepo;
import com.monkilatech.backendcampasilano.utils.ValueException;

@Service
public class DemandeServiceImpl implements DemandeService {

    @Autowired
    private DemandesRepo demandesRepo;

    @Override
    public List<Demandes> getAll() throws Exception {

        List<Demandes> demandes = this.demandesRepo.findAll();
        return demandes;
    }

    @Override
    public Demandes get(long demandeId) throws Exception {

        return this.demandesRepo.getDemandeById(demandeId);
    }

    @Override
    public Demandes getDemandeChats(String fromUid, String senderUid, String content) throws Exception {

        return this.demandesRepo.getDemandeChats(fromUid, senderUid, content);
    }

    @Override
    public List<Demandes> getMyDemande(long pageNo, long pageSize) throws Exception {

        int pgNo = (int) pageNo;
        int pgSize = (int) pageSize;

        PageRequest firstPageWithTwoElements = PageRequest.of(pgNo, pgSize);

        Page<Demandes> pagedResult = demandesRepo.findAll(firstPageWithTwoElements);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Demandes>();
        }

    }

    @Override
    public Demandes create(Demandes demandes) throws Exception {

        return this.demandesRepo.save(demandes);
    }

    @Override
    public Demandes update(Demandes demandes) throws Exception {

        return this.demandesRepo.save(demandes);
    }

    @Override
    public boolean delete(long demandeId) throws Exception {

        Demandes demandes = this.demandesRepo.getDemandeById(demandeId);
        if (demandes == null)
            throw new ValueException("Aucune Demande n'est trouvé avec l'id " + demandeId);

        this.demandesRepo.delete(demandes);

        Demandes demandesCheckOut = this.demandesRepo.getDemandeById(demandeId);

        if (demandesCheckOut != null)
            return true;
        return false;
    }

}
