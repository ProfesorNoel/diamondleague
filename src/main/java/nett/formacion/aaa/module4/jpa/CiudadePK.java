package nett.formacion.aaa.module4.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ciudades database table.
 * 
 */
@Embeddable
public class CiudadePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int idCiudad;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=75)
	private String nombrePais;

	public CiudadePK() {
	}
	public int getIdCiudad() {
		return this.idCiudad;
	}
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
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
		if (!(other instanceof CiudadePK)) {
			return false;
		}
		CiudadePK castOther = (CiudadePK)other;
		return 
			(this.idCiudad == castOther.idCiudad)
			&& this.nombrePais.equals(castOther.nombrePais);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCiudad;
		hash = hash * prime + this.nombrePais.hashCode();
		
		return hash;
	}
}