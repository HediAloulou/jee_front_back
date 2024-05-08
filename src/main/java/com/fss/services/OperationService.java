package com.fss.services;

import java.util.ArrayList;
import java.util.List;

import com.fss.entities.CompteBancaire;
import com.fss.entities.Operation;

public interface OperationService {
	void Operationsupprimer(Long id);
	//String nbOperations(Long clientId);
	void EnregistrerOperations(List<Operation> operations);
	public List<Operation> AfficherOperations();
	
	
}
