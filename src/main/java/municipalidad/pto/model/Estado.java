package municipalidad.pto.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado", catalog = "pto")
public class Estado implements Serializable {

	private Integer idEstado;
	private String estado;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_estado", unique = true, nullable = false)
	public Integer getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
	@Column(name = "estado", length = 45)
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
