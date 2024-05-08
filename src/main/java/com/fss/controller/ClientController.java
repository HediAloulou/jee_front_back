package com.fss.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fss.entities.*;
import com.fss.services.*;



@RestController
@RequestMapping(path = "/banque_client")
@CrossOrigin(origins = "http://localhost:4200")

public class ClientController {
	
	@Autowired
	ClientServiceImpl clientservice;
	
	
	
	  @GetMapping("/nbclients")
	  public String nbClients()
	  {
		  return clientservice.nbClients();
		  
	  }
	  
	  
	  @GetMapping("/clients")
	  public ArrayList <Client> AfficherClients()
	  {

		  return (ArrayList<Client>) clientservice.AfficherClients();
	  }
	  
	  
	  @GetMapping("/recherche/{id}")
	  @ResponseBody
	  public Client RechercheClient(@PathVariable Long id) 
	  {
		  Client e=clientservice.RechercheClient(id);
		  return e;
	  }
	  
	  @PostMapping("/enregistrer")

	  public void EnregistrerClient(@RequestBody Client etudiant)
	  {
		  clientservice.EnregistrerClient(etudiant);
	  }
	  
	  
	  @DeleteMapping("/supprimer/{id}")
	  public void SupprimerClient(@PathVariable("id") Long id)
	  {
		  clientservice.deleteClientAndRelatedEntities(id);
	  }

	  
}
