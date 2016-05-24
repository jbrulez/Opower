package net.pesistance.db.EntitiesOpower;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

public class Home {

	private String id;
	private String name;
	private int taille;
	private int nbPiece;
	private List<Heater> heaters;
	private List<ElectronicDevice> electronicsDevices;
	private Person person;
	
	public Home() {
		super();
	}

	public Home(String name, int taille, int nbPiece) {
		super();
		this.name = name;
		this.taille = taille;
		this.nbPiece = nbPiece;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Basic
	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name="TAILLE")
	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	@Basic
	@Column(name="NBPIECE")
	public int getNbPiece() {
		return nbPiece;
	}

	public void setNbPiece(int nbPiece) {
		this.nbPiece = nbPiece;
	}

	@XmlTransient
	@OneToMany(mappedBy = "home", cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	public List<Heater> getHeaters() {
		return heaters;
	}

	public void setHeaters(List<Heater> heaters) {
		this.heaters = heaters;
	}
	
	public void addHeater(Heater heater){
		if(heaters == null){
			heaters = new ArrayList<Heater>();
		}
		heaters.add(heater);
		heater.setHome(this);
	}

	public List<ElectronicDevice> getElectronicsDevices() {
		return electronicsDevices;
	}

	public void setElectronicsDevices(List<ElectronicDevice> electronicsDevices) {
		this.electronicsDevices = electronicsDevices;
	}
	
	public void addElectronicDevice (ElectronicDevice ed){
		if (electronicsDevices == null){
			electronicsDevices = new ArrayList<ElectronicDevice>();
		}
		electronicsDevices.add(ed);
		ed.setHome(this);
	}

	@ManyToOne
	@JoinColumn(name="PERSONID")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((electronicsDevices == null) ? 0 : electronicsDevices.hashCode());
		result = prime * result + ((heaters == null) ? 0 : heaters.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + nbPiece;
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + taille;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Home other = (Home) obj;
		if (electronicsDevices == null) {
			if (other.electronicsDevices != null)
				return false;
		} else if (!electronicsDevices.equals(other.electronicsDevices))
			return false;
		if (heaters == null) {
			if (other.heaters != null)
				return false;
		} else if (!heaters.equals(other.heaters))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nbPiece != other.nbPiece)
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (taille != other.taille)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Home [id=" + id + ", name=" + name + ", taille=" + taille + ", nbPiece=" + nbPiece + ", heaters="
				+ heaters + ", electronicsDevices=" + electronicsDevices + ", person=" + person + "]";
	}
	
}
