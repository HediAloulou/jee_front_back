package com.fss.services;

import java.util.List;

import com.fss.entities.Client;

public interface ClientService {
String nbClients();
void EnregistrerClient(Client client);
List<Client> AfficherClients();
Client RechercheClient(Long id);
void SupprimerClient(Long id);
}
