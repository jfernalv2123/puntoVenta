package municipalidad.pto.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fono", catalog = "pto")
public class Fono implements Serializable{
	
	private Integer idFono;
	private String fono;
	private Proveedor proveedor;
	public Fono(){
		
	}
	public Fono(String fono, Proveedor proveedor) {

		this.fono = fono;
		this.proveedor = proveedor;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_fono", unique = true, nullable = false)
	public Integer getIdFono() {
		return idFono;
	}
	public void setIdFono(Integer idFono) {
		this.idFono = idFono;
	}
	@Column(name = "fono", length = 45)
	public String getFono() {
		return fono;
	}
	public void setFono(String fono) {
		this.fono = fono;
	}
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "fk_proveedor")
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	

}
