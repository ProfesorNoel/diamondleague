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
	private long a�o;

	@Column(unique=true, nullable=false, length=1)
	private String categoria;

	public EdicionePK() {
	}
	public long getA�o() {
		return this.a�o;
	}
	public void setA�o(long a�o) {
		this.a�o = a�o;
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
			(this.a�o == castOther.a�o)
			&& this.categoria.equals(castOther.categoria);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.a�o ^ (this.a�o >>> 32)));
		hash = hash * prime + this.categoria.hashCode();
		
		return hash;
	}
}