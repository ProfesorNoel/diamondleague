package nett.formacion.aaa.module4.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pruebas_incluidas database table.
 * 
 */
@Entity
@Table(name="pruebas_incluidas")
@NamedQuery(name="PruebasIncluida.findAll", query="SELECT p FROM PruebasIncluida p")
public class PruebasIncluida implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PruebasIncluidaPK id;

	//bi-directional many-to-one association to Edicione
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="año", referencedColumnName="año", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="categoria", referencedColumnName="categoria", nullable=false, insertable=false, updatable=false)
		})
	private Edicione edicione;

	//bi-directional many-to-one association to Prueba
	@ManyToOne
	@JoinColumn(name="idPrueba", nullable=false, insertable=false, updatable=false)
	private Prueba prueba;

	public PruebasIncluida() {
	}

	public PruebasIncluidaPK getId() {
		return this.id;
	}

	public void setId(PruebasIncluidaPK id) {
		this.id = id;
	}

	public Edicione getEdicione() {
		return this.edicione;
	}

	public void setEdicione(Edicione edicione) {
		this.edicione = edicione;
	}

	public Prueba getPrueba() {
		return this.prueba;
	}

	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}

}