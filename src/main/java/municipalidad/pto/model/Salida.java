package municipalidad.pto.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "salida", catalog = "pto")
public class Salida implements Serializable{

	private Integer idSalida;
	private String solicitante;
	private String nSolicitud;
	private String nSalida;
	private String observaciones;
	private Date fecha;
	private boolean prestamo;
	private String destino;
	private Ubicacion ubicacion;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_salida", unique = true, nullable = false)
	public Integer getIdSalida() {
		return idSalida;
	}
	public void setIdSalida(Integer idSalida) {
		this.idSalida = idSalida;
	}
	@Column(name = "solicitante", length = 100)
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	@Column(name = "n_solicitud", length = 45)
	public String getnSolicitud() {
		return nSolicitud;
	}
	public void setnSolicitud(String nSolicitud) {
		this.nSolicitud = nSolicitud;
	}
	@Column(name = "n_salida", length = 45)
	public String getnSalida() {
		return nSalida;
	}
	public void setnSalida(String nSalida) {
		this.nSalida = nSalida;
	}
	@Column(name = "observaciones", length = 255)
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	@Column(name = "fecha")
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Column(name = "prestamo")
	public boolean isPrestamo() {
		return prestamo;
	}
	public void setPrestamo(boolean prestamo) {
		this.prestamo = prestamo;
	}
	@Column(name = "destino")
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "fk_ubicacion")
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
	
	
}
