package com.fss.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fss.entities.CompteBancaire;
import com.fss.repositories.CompteBancaireRepository;
@Service
public class CompteServiceImpl implements CompteService {
	@Autowired
	CompteBancaireRepository compteRepo;
	@Override
	public String nbComptes() {
		return "nombre de comptes bancaires egales a = " + compteRepo.count();
	}
	
	@Override
	public void EnregistrerCompte(CompteBancaire compte) {
		compteRepo.save(compte);
	}

	@Override
	public void supprimerCompte(Long id) {
		compteRepo.deleteById(id);
	}

	@Override
	public List<CompteBancaire> AfficherComptes() {

		return compteRepo.findAll();
	}

	@Override
	public String Consultation_solde(Long id) {
		CompteBancaire compte = compteRepo.findById(id).get();
		Double sum = compte.getSolde();
		return "Votre compte a " + sum;
	}


}
