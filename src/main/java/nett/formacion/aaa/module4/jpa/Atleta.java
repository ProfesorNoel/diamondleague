package nett.formacion.aaa.module4.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atletas database table.
 * 
 */
@Entity
@Table(name="atletas")
@NamedQuery(name="Atleta.findAll", query="SELECT a FROM Atleta a")
public class Atleta implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AtletaPK id;

	@Column(length=75)
	private String nombre;

	@Column(length=1)
	private String raza;

	@Column(length=1)
	private String sexo;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="NombrePais", nullable=false, insertable=false, updatable=false)
	private Pais pais;

	public Atleta() {
	}

	public AtletaPK getId() {
		return this.id;
	}

	public void setId(AtletaPK id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return this.raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}