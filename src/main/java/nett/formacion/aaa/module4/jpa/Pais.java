package nett.formacion.aaa.module4.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the paises database table.
 * 
 */
@Entity
@Table(name="paises")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false, length=75)
	private String nombrePais;

	//bi-directional many-to-one association to Atleta
	@OneToMany(mappedBy="pais", fetch=FetchType.EAGER)
	private Set<Atleta> atletas;

	//bi-directional many-to-one association to Ciudade
	@OneToMany(mappedBy="pais", fetch=FetchType.EAGER)
	private Set<Ciudade> ciudades;

	public Pais() {
	}

	public String getNombrePais() {
		return this.nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public Set<Atleta> getAtletas() {
		return this.atletas;
	}

	public void setAtletas(Set<Atleta> atletas) {
		this.atletas = atletas;
	}

	public Atleta addAtleta(Atleta atleta) {
		getAtletas().add(atleta);
		atleta.setPais(this);

		return atleta;
	}

	public Atleta removeAtleta(Atleta atleta) {
		getAtletas().remove(atleta);
		atleta.setPais(null);

		return atleta;
	}

	public Set<Ciudade> getCiudades() {
		return this.ciudades;
	}

	public void setCiudades(Set<Ciudade> ciudades) {
		this.ciudades = ciudades;
	}

	public Ciudade addCiudade(Ciudade ciudade) {
		getCiudades().add(ciudade);
		ciudade.setPais(this);

		return ciudade;
	}

	public Ciudade removeCiudade(Ciudade ciudade) {
		getCiudades().remove(ciudade);
		ciudade.setPais(null);

		return ciudade;
	}

}