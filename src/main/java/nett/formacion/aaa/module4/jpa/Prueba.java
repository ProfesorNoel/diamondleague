package nett.formacion.aaa.module4.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the pruebas database table.
 * 
 */
@Entity
@Table(name="pruebas")
@NamedQuery(name="Prueba.findAll", query="SELECT p FROM Prueba p")
public class Prueba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false)
	private int idPrueba;

	@Column(nullable=false, length=45)
	private String nombrePrueba;

	//bi-directional many-to-one association to PruebasIncluida
	@OneToMany(mappedBy="prueba", fetch=FetchType.EAGER)
	private Set<PruebasIncluida> pruebasIncluidas;

	public Prueba() {
	}

	public int getIdPrueba() {
		return this.idPrueba;
	}

	public void setIdPrueba(int idPrueba) {
		this.idPrueba = idPrueba;
	}

	public String getNombrePrueba() {
		return this.nombrePrueba;
	}

	public void setNombrePrueba(String nombrePrueba) {
		this.nombrePrueba = nombrePrueba;
	}

	public Set<PruebasIncluida> getPruebasIncluidas() {
		return this.pruebasIncluidas;
	}

	public void setPruebasIncluidas(Set<PruebasIncluida> pruebasIncluidas) {
		this.pruebasIncluidas = pruebasIncluidas;
	}

	public PruebasIncluida addPruebasIncluida(PruebasIncluida pruebasIncluida) {
		getPruebasIncluidas().add(pruebasIncluida);
		pruebasIncluida.setPrueba(this);

		return pruebasIncluida;
	}

	public PruebasIncluida removePruebasIncluida(PruebasIncluida pruebasIncluida) {
		getPruebasIncluidas().remove(pruebasIncluida);
		pruebasIncluida.setPrueba(null);

		return pruebasIncluida;
	}

}