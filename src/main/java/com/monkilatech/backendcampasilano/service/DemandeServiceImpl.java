package com.monkilatech.backendcampasilano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
