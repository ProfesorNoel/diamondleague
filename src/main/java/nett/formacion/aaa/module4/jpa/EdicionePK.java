package nett.formacion.aaa.module4.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ediciones database table.
 * 
 */
@Embeddable
public class EdicionePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, precision=10)
	private long año;

	@Column(unique=true, nullable=false, length=1)
	private String categoria;

	public EdicionePK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EdicionePK)) {
			return false;
		}
		EdicionePK castOther = (EdicionePK)other;
		return 
			(this.año == castOther.año)
			&& this.categoria.equals(castOther.categoria);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.año ^ (this.año >>> 32)));
		hash = hash * prime + this.categoria.hashCode();
		
		return hash;
	}
}