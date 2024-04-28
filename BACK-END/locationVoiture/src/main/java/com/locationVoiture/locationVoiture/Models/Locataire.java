package com.locationVoiture.locationVoiture.Models;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "Locataire")
@DiscriminatorColumn(name="LocataireType")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Locataire extends Personne{


	public Locataire(Long id, String nom, String prenom, String adresse, int numtel,
			Set<LouerVoiture> listeLocationsLocataire) {
		super(id, nom, prenom, adresse, numtel);
		this.listeLocationsLocataire = listeLocationsLocataire;
	}
	
	
	

	public Locataire() {
	
	}



	@JsonIgnore
	@OneToMany(mappedBy = "locataireLouer",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   	private Set<LouerVoiture> listeLocationsLocataire;


	public Set<LouerVoiture> getListeLocationsLocataire() {
		return listeLocationsLocataire;
	}

	public void setListeLocationsLocataire(Set<LouerVoiture> listeLocationsLocataire) {
		this.listeLocationsLocataire = listeLocationsLocataire;
	}
    
    
}
