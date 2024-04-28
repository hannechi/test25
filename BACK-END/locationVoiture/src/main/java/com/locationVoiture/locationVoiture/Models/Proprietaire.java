package com.locationVoiture.locationVoiture.Models;

import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Proprietaire")
@DiscriminatorColumn(name="ProprietaireType")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Proprietaire extends Personne{

	/*Ajout de la relation OneToMany entre Proprietaire et Voiture*/
	@JsonIgnore
    @OneToMany(mappedBy = "voitureProprietaire", fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Voiture> voitures;

	public Proprietaire(Long id, String nom, String prenom, String adresse, int numtel, Set<Voiture> voitures) {
		super(id, nom, prenom, adresse, numtel);
		this.voitures = voitures;
	}
	
	public Proprietaire() {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(voitures);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proprietaire other = (Proprietaire) obj;
		return Objects.equals(voitures, other.voitures);
	}

	public Set<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(Set<Voiture> voitures) {
		this.voitures = voitures;
	}
    
	
    
}
