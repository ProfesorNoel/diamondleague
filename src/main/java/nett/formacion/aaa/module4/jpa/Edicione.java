package nett.formacion.aaa.module4.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the ediciones database table.
 * 
 */
@Entity
@Table(name="ediciones")
@NamedQuery(name="Edicione.findAll", query="SELECT e FROM Edicione e")
public class Edicione implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EdicionePK id;

	private int edicion;

	//bi-directional many-to-one association to PruebasIncluida
	@OneToMany(mappedBy="edicione", fetch=FetchType.EAGER)
	private Set<PruebasIncluida> pruebasIncluidas;

	public Edicione() {
	}

	public EdicionePK getId() {
		return this.id;
	}

	public void setId(EdicionePK id) {
		this.id = id;
	}

	public int getEdicion() {
		return this.edicion;
	}

	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}

	public Set<PruebasIncluida> getPruebasIncluidas() {
		return this.pruebasIncluidas;
	}

	public void setPruebasIncluidas(Set<PruebasIncluida> pruebasIncluidas) {
		this.pruebasIncluidas = pruebasIncluidas;
	}

	public PruebasIncluida addPruebasIncluida(PruebasIncluida pruebasIncluida) {
		getPruebasIncluidas().add(pruebasIncluida);
		pruebasIncluida.setEdicione(this);

		return pruebasIncluida;
	}

	public PruebasIncluida removePruebasIncluida(PruebasIncluida pruebasIncluida) {
		getPruebasIncluidas().remove(pruebasIncluida);
		pruebasIncluida.setEdicione(null);

		return pruebasIncluida;
	}

}