package com.locationVoiture.locationVoiture.Models;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Marque")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Marque {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="libelleMarque",nullable=false)
	private String libelleMarque;
	
	
	@Column(name="description",nullable=true)
	private String description;

	@JsonIgnore
    @OneToMany(mappedBy = "voitureMarque",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   	private Set<Voiture> ListeVoituresMarque;


	public Marque(Long id, String libelleMarque, String description, Set<Voiture> listeVoituresMarque) {
		super();
		this.id = id;
		this.libelleMarque = libelleMarque;
		this.description = description;
		this.ListeVoituresMarque = listeVoituresMarque;
	}


	public Marque() {
		
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLibelleMarque() {
		return libelleMarque;
	}


	public void setLibelleMarque(String libelleMarque) {
		this.libelleMarque = libelleMarque;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Set<Voiture> getListeVoituresMarque() {
		return ListeVoituresMarque;
	}


	public void setListeVoituresMarque(Set<Voiture> listeVoituresMarque) {
		this.ListeVoituresMarque = listeVoituresMarque;
	}
	    
    
	
}
