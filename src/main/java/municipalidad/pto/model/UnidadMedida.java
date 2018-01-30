package municipalidad.pto.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unidad_medida", catalog = "pto")
public class UnidadMedida implements Serializable {
	private Integer idUnidadMedida;
	private String unidadMedida;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_unidad_medida", unique = true, nullable = false)
	public Integer getIdUnidadMedida() {
		return idUnidadMedida;
	}
	public void setIdUnidadMedida(Integer idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}
	@Column(name = "unidad_medida", length = 45)
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	

}
