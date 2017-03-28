package nett.formacion.aaa.module4.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the atletas database table.
 * 
 */
@Embeddable
public class AtletaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private String idAtleta;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=75)
	private String nombrePais;

	public AtletaPK() {
	}
	public String getIdAtleta() {
		return this.idAtleta;
	}
	public void setIdAtleta(String idAtleta) {
		this.idAtleta = idAtleta;
	}
	public String getNombrePais() {
		return this.nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AtletaPK)) {
			return false;
		}
		AtletaPK castOther = (AtletaPK)other;
		return 
			this.idAtleta.equals(castOther.idAtleta)
			&& this.nombrePais.equals(castOther.nombrePais);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idAtleta.hashCode();
		hash = hash * prime + this.nombrePais.hashCode();
		
		return hash;
	}
}