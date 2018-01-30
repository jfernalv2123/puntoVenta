package municipalidad.pto.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rel_informe_articulo", catalog = "pto")
public class RelInformeArticulo implements Serializable{

	private Integer idRelInformeArticulo;
	private Articulos articulo;
	private InformeInventario informe;
	private Integer cantidad;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_rel_informe_articulo", unique = true, nullable = false)
	public Integer getIdRelInformeArticulo() {
		return idRelInformeArticulo;
	}
	public void setIdRelInformeArticulo(Integer idRelInformeArticulo) {
		this.idRelInformeArticulo = idRelInformeArticulo;
	}
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "fk_articulo")
	public Articulos getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulos articulo) {
		this.articulo = articulo;
	}
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "fk_informe")
	public InformeInventario getInforme() {
		return informe;
	}
	public void setInforme(InformeInventario informe) {
		this.informe = informe;
	}
	@Column(name = "cantidad")
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
