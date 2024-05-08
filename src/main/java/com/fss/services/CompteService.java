package com.fss.services;

import java.util.List;

import com.fss.entities.Client;
import com.fss.entities.CompteBancaire;

public interface CompteService {

String nbComptes();
void EnregistrerCompte(CompteBancaire compte);
void supprimerCompte(Long id);
public List <CompteBancaire> AfficherComptes();
String Consultation_solde(Long id);
public String Afficher_proprietaire(Long id);
String Extraire(Long id,Double mon);
String Ajouter(Long id,Double mon);
public void deleteAccountAndRelatedEntities(Long compteId);

}
