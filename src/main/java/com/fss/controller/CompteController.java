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
@RequestMapping(path = "/banque_compte")
@CrossOrigin(origins = "http://localhost:4200")
public class CompteController {
    @Autowired
    CompteService compteservice;
    
    @GetMapping("/nbcomptes")
    public String nbClients() {
        return compteservice.nbComptes();
    }
    
    @GetMapping("/comptes")
    public ArrayList<CompteBancaire> AfficherComptes() {
        return (ArrayList<CompteBancaire>) compteservice.AfficherComptes();
    }
    
    @GetMapping("/solde")
    String Affichersolde(Long id) {
        return compteservice.Consultation_solde(id);
    }
    
    @GetMapping("/proprietaire")
    String Afficher_proprietaire(Long id) {
        return compteservice.Afficher_proprietaire(id);
    }
    
    @DeleteMapping("/supprimer/{id}")
    public void SupprimerClient(@PathVariable("id") Long id) {
        compteservice.deleteAccountAndRelatedEntities(id);
    }
    
    @PostMapping("/extraire/{id}/{montant}")
    public String extraire(@PathVariable("id") Long id, @PathVariable("montant") Double montant) {
        return compteservice.Extraire(id, montant);
    }
    
    @PostMapping("/ajouter/{id}/{montant}")
    public String ajouter(@PathVariable("id") Long id, @PathVariable("montant") Double montant) {
        return compteservice.Ajouter(id, montant);
    }
}
