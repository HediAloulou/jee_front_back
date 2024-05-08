package com.fss.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.fss.entities.CompteBancaire;

import jakarta.transaction.Transactional;

public interface CompteBancaireRepository extends JpaRepository<CompteBancaire, Long>{
	 @Transactional
	 @Modifying
	 @Query("UPDATE CompteBancaire c SET c.solde = :solde WHERE c.id = :compteId")
	  void updateMontantById(Long compteId, Double solde);
	  void deleteByClient_Id(Long clientId);

}
