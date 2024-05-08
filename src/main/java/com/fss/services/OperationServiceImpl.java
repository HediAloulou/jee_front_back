package com.fss.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fss.entities.CompteBancaire;
import com.fss.entities.Operation;
import com.fss.entities.TypeOperation;
import com.fss.repositories.CompteBancaireRepository;
import com.fss.repositories.OperationRepository;
@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	OperationRepository operationRepo;
	/* @Override
	//public String nbOperations(Long clientId) {
	//	return "nb operation d'un client x egale a " + operationRepo.countByClientId(clientId)	;
	}*/

	public void EnregistrerOperations(ArrayList <Operation> operations) {
		operationRepo.saveAll(operations);
		
	}

	@Override
	public void Operationsupprimer(Long id) {
operationRepo.deleteById(id);		
	}

	@Override
	public void EnregistrerOperations(List<Operation> operations) {
		operationRepo.saveAll(operations);
		
	}

	@Override
	public List<Operation> AfficherOperations() {
		return operationRepo.findAll();
		
	}
	
	
	
	}
	


