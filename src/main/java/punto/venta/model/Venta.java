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
@Table(name = "venta", catalog = "punto_venta")
public class Venta implements Serializable{

	
	private Integer id;
	private Usuario usuario;
	private Date fecha;
	private Integer descuento;
	private boolean tipoDescuento;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_venta", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "fk_usuario")
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Column(name = "fecha")
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Column(name = "descuento")
	public Integer getDescuento() {
		return descuento;
	}
	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}
	@Column(name = "tipo_descuento")
	public boolean isTipoDescuento() {
		return tipoDescuento;
	}
	public void setTipoDescuento(boolean tipoDescuento) {
		this.tipoDescuento = tipoDescuento;
	}
	
	
}
