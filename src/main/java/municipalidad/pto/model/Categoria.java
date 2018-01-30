package municipalidad.pto.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria", catalog = "pto")
public class Categoria implements Serializable{

	private Integer idCategoria;
	private String categoria;
	public Categoria(){
		
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_categoria", unique = true, nullable = false)
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	@Column(name = "categoria", length = 45)
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
