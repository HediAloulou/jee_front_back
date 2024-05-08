package com.fss.entities;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Operation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "identification_operation")
	private Long id;
	@Column(name = "date_operation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
	@Column(name="montant")
	@JsonIgnore
	private Double montant;
	@Column(name = "type_opearion")
	@Enumerated(EnumType.STRING)
	private TypeOperation type;
	@ManyToOne
	@JoinColumn(name="operation_compte")
	@JsonIgnore
	private CompteBancaire comptebancaire;
}
