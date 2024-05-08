package com.fss.services;

import java.util.List;

import com.fss.entities.Client;

public interface ClientService {
String nbClients();
void EnregistrerClient(Client client);
public List<Client> AfficherClients();
Client RechercheClient(Long id);
void SupprimerClient(Long id);
public void deleteClientAndRelatedEntities(Long clientId);
}
