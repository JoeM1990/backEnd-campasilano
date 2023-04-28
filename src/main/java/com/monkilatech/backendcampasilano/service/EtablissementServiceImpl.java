package com.monkilatech.backendcampasilano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monkilatech.backendcampasilano.model.Etablissement;
import com.monkilatech.backendcampasilano.repository.EtablissementRepo;
import com.monkilatech.backendcampasilano.utils.ValueException;

@Service
public class EtablissementServiceImpl implements EtablissementService {

    @Autowired
    private EtablissementRepo etablissementRepo;

    @Override
    public List<Etablissement> getAll() throws Exception {
        List<Etablissement> etablissements = this.etablissementRepo.findAll();

        return etablissements;
    }

    @Override
    public Etablissement get(long etablissementId) throws Exception {

        return this.etablissementRepo.getEtablissementById(etablissementId);
    }

    @Override
    public Etablissement create(Etablissement etablissement) throws Exception {

        return this.etablissementRepo.save(etablissement);
    }

    @Override
    public Etablissement update(Etablissement etablissement) throws Exception {

        return this.etablissementRepo.save(etablissement);
    }

    @Override
    public boolean delete(long etablissementId) throws Exception {

        Etablissement etablissement = this.etablissementRepo.getEtablissementById(etablissementId);
        if (etablissement == null)
            throw new ValueException("Aucun etablissement n'est trouvé avec l'id " + etablissementId);

        this.etablissementRepo.delete(etablissement);

        Etablissement etablissementCheckOut = this.etablissementRepo.getEtablissementById(etablissementId);

        if (etablissementCheckOut != null)
            return true;
        return false;
    }

}
