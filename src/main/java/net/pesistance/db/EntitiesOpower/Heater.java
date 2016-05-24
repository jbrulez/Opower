package net.pesistance.db.EntitiesOpower;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.jpa.config.Cascade;

@Entity
@Table(name="HEATER")
public class Heater {
	
	private String id;
	private String name;
	private String consoMoyenne;
	private Home home;
	
	public Heater() {
		super();
	}

	public Heater(String name, String conso) {
		super();
		this.name = name;
		this.consoMoyenne = conso;
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
	@Column(name="CONSO")
	public String getConso() {
		return consoMoyenne;
	}

	public void setConso(String conso) {
		this.consoMoyenne = conso;
	}

	@ManyToOne
	@JoinColumn(name="HOMEID")
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consoMoyenne == null) ? 0 : consoMoyenne.hashCode());
		result = prime * result + ((home == null) ? 0 : home.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Heater other = (Heater) obj;
		if (consoMoyenne == null) {
			if (other.consoMoyenne != null)
				return false;
		} else if (!consoMoyenne.equals(other.consoMoyenne))
			return false;
		if (home == null) {
			if (other.home != null)
				return false;
		} else if (!home.equals(other.home))
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
		return true;
	}

	@Override
	public String toString() {
		return "Heater [id=" + id + ", name=" + name + ", conso=" + consoMoyenne + ", home=" + home + "]";
	}
	
}
