package com.fss.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fss.entities.CompteBancaire;
import com.fss.repositories.ClientRepository;
import com.fss.repositories.CompteBancaireRepository;
import com.fss.repositories.OperationRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import com.fss.entities.Client;

@Service
public class CompteServiceImpl implements CompteService {
	@Autowired
	CompteBancaireRepository compteRepo;
	@Autowired
	ClientRepository clientrepo;
	
	@Autowired
	OperationRepository operRepo;
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
	public String Afficher_proprietaire(Long id)
	{
		CompteBancaire c = compteRepo.findById(id).get();
		Client c1= c.getClient();
		String nom = c1.getNom();
		String prenom = c1.getPrenom();
		return " Le proprietaire de ces comptes est " + prenom +" "+ nom;
	}

	public String Extraire(Long id,Double mon) {
	    CompteBancaire compte = compteRepo.findById(id).get();
		if( mon > compte.getSolde())
	    {
	    	return "Vous n'avez pas le droit de retirer ce montant";
	    }
	    else
		{compteRepo.updateMontantById(id,compteRepo.findById(id).get().getSolde()-mon);
		return "Votre montant actuel est : "+compte.getSolde();
	}
	}
	@Override
	public String Ajouter(Long id,Double mon) {
		compteRepo.updateMontantById(id,compteRepo.findById(id).get().getSolde()+mon);
		return "Votre montant actuel est : "+compteRepo.findById(id).get().getSolde();
	}
	@Override
    @Transactional
    public void deleteAccountAndRelatedEntities(Long compteId) {
        // Delete operations associated with the compte
        operRepo.deleteByComptebancaire_Id(compteId);

        // Find the compte
        Optional<CompteBancaire> optionalCompte = compteRepo.findById(compteId);
        if (optionalCompte.isPresent()) {
            CompteBancaire compte = optionalCompte.get();
            Client client = compte.getClient();

            // Remove the compte from the client's list of comptes
            client.getCompte_client().remove(compte);

            // Delete the client if it has no more comptes associated with it
            if (client.getCompte_client().isEmpty()) {
                clientrepo.deleteById(client.getId());
            }

            // Delete the compte
            compteRepo.deleteById(compteId);
        } else {
            throw new EntityNotFoundException("CompteBancaire with id " + compteId + " not found");
        }
    }
}
