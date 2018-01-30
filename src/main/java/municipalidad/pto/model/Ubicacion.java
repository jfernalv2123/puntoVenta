package municipalidad.pto.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ubicacion", catalog = "pto")
public class Ubicacion implements java.io.Serializable{
	
	private Integer idUbicacion;
	private String ubicacion;
	
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_ubicacion", unique = true, nullable = false)
	public Integer getIdUbicacion() {
		return idUbicacion;
	}
	public void setIdUbicacion(Integer idUbicacion) {
		this.idUbicacion = idUbicacion;
	}
	@Column(name = "ubicacion", length = 100)
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	

}
