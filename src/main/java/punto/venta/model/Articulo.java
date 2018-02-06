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
@Table(name = "articulo", catalog = "punto_venta")
public class Articulo implements Serializable{

	private Integer id;
	private String codigo;
	private String articulo;
	private String marca;
	private Proveedor proveedor;
	private TipoArticulo tipo;
	private TipoUnidad tipoUnidad;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_articulo", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "codigo", length = 200)
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	@Column(name = "articulo", length = 100)
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	@Column(name = "marca", length = 100)
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "fk_proveedor")
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "fk_tipo")
	public TipoArticulo getTipo() {
		return tipo;
	}
	public void setTipo(TipoArticulo tipo) {
		this.tipo = tipo;
	}
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "fk_unidad")
	public TipoUnidad getTipoUnidad() {
		return tipoUnidad;
	}
	public void setTipoUnidad(TipoUnidad tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}
	
	
}
