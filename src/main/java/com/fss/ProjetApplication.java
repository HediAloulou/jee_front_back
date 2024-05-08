package com.fss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fss.entities.Client;
import com.fss.entities.CompteBancaire;
import com.fss.entities.CompteCourant;
import com.fss.entities.CompteStatus;
import com.fss.entities.Operation;
import com.fss.entities.TypeOperation;
import com.fss.services.ClientService;
import com.fss.services.CompteService;
import com.fss.services.OperationService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ProjetApplication implements CommandLineRunner {

    @Autowired
    private ClientService clientService;
    
    @Autowired
    private OperationService operationService;
    
    @Autowired
    private CompteService compteService;

    public static void main(String[] args) {
        SpringApplication.run(ProjetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createAndSaveClients();
        createAndSaveOperations();
    }

    private void createAndSaveClients() {
        Client client1 = new Client(1L, "aloulou", "hedi", "hedialoulou90@gmail.com", null);
        clientService.EnregistrerClient(client1);

        Client client2 = new Client(2L, "alimi", "aymen", "aymen4070@gmail.com", null);
        clientService.EnregistrerClient(client2);
    }

    private void createAndSaveOperations() {
        List<Operation> operations1 = new ArrayList<>();
        List<Operation> operations2 = new ArrayList<>();
        
        Client client1 = clientService.RechercheClient(1L); 
        Client client2 = clientService.RechercheClient(2L);
        
        // enregistrer le compte du premier client
        CompteBancaire comptebancaire1 = new CompteBancaire(1L, new Date(), 500.25, CompteStatus.ACTIVE, client1, operations1);
        compteService.EnregistrerCompte(comptebancaire1);        
        System.out.println(compteService.Consultation_solde(1L));

        Operation operation1 = new Operation(1L, new Date(), 22.5, TypeOperation.DEBIT, comptebancaire1);
        operations1.add(operation1);
        compteService.Extraire(operation1.getComptebancaire().getId(), 22.5);
        System.out.println(compteService.Consultation_solde(1L));

        Operation operation2 = new Operation(2L, new Date(), 50.0, TypeOperation.CREDIT, comptebancaire1);
        operations1.add(operation2);
        compteService.Ajouter(operation2.getComptebancaire().getId(), 50.2);
        comptebancaire1.setOperations(operations1);
        operationService.EnregistrerOperations(operations1);
        System.out.println(compteService.Consultation_solde(1L));

        
        // enregistrer le compte du deuxième client
        CompteBancaire comptebancaire2 = new CompteBancaire(2L, new Date(), 1000.25, CompteStatus.ACTIVE, client2, operations2);
        compteService.EnregistrerCompte(comptebancaire2);

        Operation operation3 = new Operation(3L, new Date(), 30.0, TypeOperation.DEBIT, comptebancaire2);
        operations2.add(operation3);

        Operation operation4 = new Operation(4L, new Date(), 50.0, TypeOperation.CREDIT, comptebancaire2);
        operations2.add(operation4);
        
        comptebancaire2.setOperations(operations2);

        operationService.EnregistrerOperations(operations2);
        
        // enregistrer un compte courant
        CompteCourant compteCourant3 = new CompteCourant();
        compteCourant3.setId(3L);
        compteCourant3.setDateCreation(new Date());
        compteCourant3.setSolde(1340.0);
        compteCourant3.setEtat(CompteStatus.ACTIVE);
        compteCourant3.setClient(client2); // Assuming client2 is an existing client
        compteCourant3.setOperations(operations2); // Assuming operations2 is an existing list of operations
        compteCourant3.setDecouvert(10.5);
        compteService.EnregistrerCompte(compteCourant3);
        	
        
        
    }
}
