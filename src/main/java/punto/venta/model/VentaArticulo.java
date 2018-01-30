package punto.venta.model;

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
@Table(name = "venta_articulo", catalog = "punto_venta")
public class VentaArticulo implements Serializable {


	
	private Integer id;
	private Articulo articulo;
	private Venta venta;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_venta_articulo", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "fk_articulo")
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "fk_venta")
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
}
