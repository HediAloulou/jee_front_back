package com.fss.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fss.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{

	//String countByClientId(Long clientId);
	void deleteByComptebancaire_Client_Id(Long clientId);

	void deleteByComptebancaire_Id(Long compteId);

}
