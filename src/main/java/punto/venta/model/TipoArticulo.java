package punto.venta.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_articulo", catalog = "punto_venta")
public class TipoArticulo implements Serializable{

	private Integer id;
	private String tipo;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_tipo_articulo", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "tipo", length = 45)
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
