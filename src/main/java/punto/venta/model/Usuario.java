package punto.venta.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario", catalog = "punto_venta")
public class Usuario implements Serializable{

	
	private Integer id;
	private String rut;
	private String nombre;
	private String nombre2;
	private String apellido;
	private String apellido2;
	private String pass;
	private Integer nivel;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_usuario", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "rut", length = 100)
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	@Column(name = "nombre", length = 100)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(name = "nombre2", length = 100)
	public String getNombre2() {
		return nombre2;
	}
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	@Column(name = "apellido", length = 100)
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Column(name = "apellido2", length = 100)
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	@Column(name = "pass", length = 100)
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Column(name = "nivel")
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	
	
}
