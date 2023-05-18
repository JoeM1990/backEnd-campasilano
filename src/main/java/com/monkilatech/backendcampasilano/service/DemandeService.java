package com.monkilatech.backendcampasilano.service;

import java.util.List;

import com.monkilatech.backendcampasilano.model.Demandes;

public interface DemandeService {

    public List<Demandes> getAll() throws Exception;

    public Demandes get(long demandeId) throws Exception;

    public Demandes getDemandeChats(long fromUid, long senderUid) throws Exception;

    public Demandes create(Demandes demandes) throws Exception;

    public Demandes update(Demandes demandes) throws Exception;

    public boolean delete(long demandeId) throws Exception;
}
