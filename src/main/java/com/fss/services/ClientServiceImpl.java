package com.fss.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fss.repositories.ClientRepository;
import com.fss.repositories.CompteBancaireRepository;
import com.fss.repositories.OperationRepository;
import com.fss.entities.Client;
import com.fss.entities.CompteBancaire;

import jakarta.transaction.Transactional;


@Service
public class ClientServiceImpl implements ClientService {
@Autowired
ClientRepository clientrepo;
@Autowired
CompteBancaireRepository compterepo;
@Autowired
OperationRepository operRepo;
public void EnregistrerClient(Client client)
{
	clientrepo.save(client);
	System.out.println("client enregistré");
}
public String nbClients()
{
	return "Le nombre de clients egale a : " + clientrepo.count();
}
public List<Client> AfficherClients()
{
	return clientrepo.findAll();
	
}
public Client RechercheClient(Long id)
{
	return clientrepo.findById(id).get();
}
public void SupprimerClient(Long id)
{
	
	operRepo.deleteById(id);
	compterepo.deleteById(id);
	clientrepo.deleteById(id);
	
	System.out.println("One client has been removed from the database");
}
@Transactional
public void deleteClientAndRelatedEntities(Long clientId) {
    // Delete operations associated with the client
    operRepo.deleteByComptebancaire_Client_Id(clientId);

    // Delete comptes associated with the client
    compterepo.deleteByClient_Id(clientId);

    // Delete the client
    clientrepo.deleteById(clientId);
}

}
