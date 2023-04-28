package com.monkilatech.backendcampasilano.service;

import java.util.List;

import com.monkilatech.backendcampasilano.model.Etablissement;

public interface EtablissementService {
    public List<Etablissement> getAll() throws Exception;

    public Etablissement get(long etablissementId) throws Exception;

    public Etablissement create(Etablissement etablissement) throws Exception;

    public Etablissement update(Etablissement etablissement) throws Exception;

    public boolean delete(long etablissementId) throws Exception;
}
