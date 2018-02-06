package punto.venta.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingreso_articulo", catalog = "punto_venta")
public class IngresoArticulo implements Serializable{
	
	
	private Integer id;
	private Articulo articulo;
	private Date fecha;
	private Integer cantidad;
	private Integer valor;
	private Integer costo;
	private Usuario usuario;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_ingreso_articulo", unique = true, nullable = false)
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
	@Column(name = "fecha")
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Column(name = "catidad")
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	@Column(name = "valor_venta")
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	@Column(name = "costo")
	public Integer getCosto() {
		return costo;
	}
	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "fk_usuario")
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
