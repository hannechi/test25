package com.locationVoiture.locationVoiture.Models;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Model")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Model {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="libelleModel",nullable=false)
	private String libelleModel;
	
	
	@Column(name="description",nullable=true)
	private String description;

	@JsonIgnore
    @OneToMany(mappedBy = "voitureModel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   	private Set<Voiture> ListeVoituresModel;



	public Model(Long id, String libelleModel, String description, Set<Voiture> listeVoituresModel) {
		super();
		this.id = id;
		this.libelleModel = libelleModel;
		this.description = description;
		this.ListeVoituresModel = listeVoituresModel;
	}

	public Model() {
		
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", libelleModel=" + libelleModel + ", description=" + description
				+ ", ListeVoituresModel=" + ListeVoituresModel + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLibelleModel() {
		return libelleModel;
	}


	public void setLibelleModel(String libelleModel) {
		this.libelleModel = libelleModel;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Set<Voiture> getListeVoituresModel() {
		return ListeVoituresModel;
	}


	public void setListeVoituresModel(Set<Voiture> listeVoituresModel) {
		this.ListeVoituresModel = listeVoituresModel;
	}
	

}
