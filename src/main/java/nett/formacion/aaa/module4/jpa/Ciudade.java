package nett.formacion.aaa.module4.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ciudades database table.
 * 
 */
@Entity
@Table(name="ciudades")
@NamedQuery(name="Ciudade.findAll", query="SELECT c FROM Ciudade c")
public class Ciudade implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CiudadePK id;

	@Column(length=45)
	private String nombreCiudad;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="NombrePais", nullable=false, insertable=false, updatable=false)
	private Pais pais;

	public Ciudade() {
	}

	public CiudadePK getId() {
		return this.id;
	}

	public void setId(CiudadePK id) {
		this.id = id;
	}

	public String getNombreCiudad() {
		return this.nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}