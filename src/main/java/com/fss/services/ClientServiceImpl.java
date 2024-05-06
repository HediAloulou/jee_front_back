package com.fss.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fss.repositories.ClientRepository;

import com.fss.entities.Client;
import jakarta.transaction.Transactional;


@Service
public class ClientServiceImpl implements ClientService {
@Autowired
ClientRepository clientrepo;
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
	clientrepo.deleteById(id);
}

}
