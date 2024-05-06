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


}
