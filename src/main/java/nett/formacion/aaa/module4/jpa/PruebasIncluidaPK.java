package nett.formacion.aaa.module4.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pruebas_incluidas database table.
 * 
 */
@Embeddable
public class PruebasIncluidaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long año;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=1)
	private String categoria;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int idPrueba;

	@Column(unique=true, nullable=false)
	private int orden;

	public PruebasIncluidaPK() {
	}
	public long getAño() {
		return this.año;
	}
	public void setAño(long año) {
		this.año = año;
	}
	public String getCategoria() {
		return this.categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getIdPrueba() {
		return this.idPrueba;
	}
	public void setIdPrueba(int idPrueba) {
		this.idPrueba = idPrueba;
	}
	public int getOrden() {
		return this.orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PruebasIncluidaPK)) {
			return false;
		}
		PruebasIncluidaPK castOther = (PruebasIncluidaPK)other;
		return 
			(this.año == castOther.año)
			&& this.categoria.equals(castOther.categoria)
			&& (this.idPrueba == castOther.idPrueba)
			&& (this.orden == castOther.orden);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.año ^ (this.año >>> 32)));
		hash = hash * prime + this.categoria.hashCode();
		hash = hash * prime + this.idPrueba;
		hash = hash * prime + this.orden;
		
		return hash;
	}
}