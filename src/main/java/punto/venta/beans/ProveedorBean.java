package punto.venta.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import punto.venta.constantes.Constantes;
import punto.venta.model.Proveedor;
import punto.venta.service.ProveedorService;

@ManagedBean
@SessionScoped
public class ProveedorBean implements Serializable{

	@ManagedProperty(value = "#{proveedorService}")
	ProveedorService proveedorService;
	
	public void setProveedorService(ProveedorService proveedorService) {
		this.proveedorService = proveedorService;
	}
	
	
	private String nombre;
	private String rut;
	private String razonSocial;
	private Proveedor proveedorAux;
	private String fono;
	private String mail;
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	public Proveedor getProveedorAux() {
		return proveedorAux;
	}
	public void setProveedorAux(Proveedor proveedorAux) {
		this.proveedorAux = proveedorAux;
	}
	public String getFono() {
		return fono;
	}
	public void setFono(String fono) {
		this.fono = fono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void guardar(){
		Proveedor proveedor=new Proveedor();
		proveedor.setNombre(getNombre());
		proveedor.setRazonSocial(getRazonSocial());
		proveedor.setRut(getRut());
		proveedor.setFono(getFono());
		proveedor.setMail(getMail());
		proveedorService.guardar(proveedor);
		mensaje(Constantes.GUARDADO,proveedor.getNombre());
	}
	public List<SelectItem> combo(){
		return proveedorService.combo();
	}
	public List<Proveedor> lista(){
		return proveedorService.lista();
	}
	public void carga(Proveedor pro){
		proveedorAux=pro;
	}
	public void borrar(Proveedor pro){
		proveedorService.borrar(pro);
		mensaje(Constantes.BORRADO,pro.getNombre());
	}
	public void modificar(){
		proveedorService.actualizar(proveedorAux);
		mensaje(Constantes.MODIFICADO,proveedorAux.getNombre());
	}
	public void mensaje(String titulo, String mensaje) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(titulo, mensaje));
	}
	
	
}
