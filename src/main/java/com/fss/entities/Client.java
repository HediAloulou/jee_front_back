package com.fss.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "identification_client")
	private Long id;
	@Column(name= "nom_client")
	private String nom;
	@Column(name="prenom_du_client")
	private String prenom;
	@Column(name = "email_du_client")
	private String email;
	@OneToMany(mappedBy = "client") 
	@JsonIgnore
	private List<CompteBancaire> compte_client;
}
