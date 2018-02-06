package punto.venta.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import punto.venta.constantes.Constantes;
import punto.venta.model.Usuario;
import punto.venta.service.UsuarioService;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	@ManagedProperty(value = "#{usuarioService}")
	UsuarioService usuarioService;

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	private Usuario usuarioAux;
	private String rut;
	private String nombre;
	private String nombre2;
	private String apellido;
	private String apellido2;
	private String pass;
	private Integer nivel;

	public Usuario getUsuarioAux() {
		return usuarioAux;
	}
	public void setUsuarioAux(Usuario usuarioAux) {
		this.usuarioAux = usuarioAux;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre2() {
		return nombre2;
	}
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public void carga(Usuario user){
		usuarioAux=user;
	}
	public void guardar(){
		Usuario user =new Usuario();
		user.setRut(getRut());
		user.setApellido(getApellido());
		user.setApellido2(getApellido2());
		user.setNombre(getNombre());
		user.setNombre2(getNombre2());
		user.setNivel(getNivel());
		user.setPass(usuarioService.encripta(getPass(), Constantes.MD5) );
		usuarioService.guardar(user);
		mensaje(Constantes.GUARDADO,user.getNombre()+Constantes.ESPACIO+user.getApellido());
	}
	public void modificar(){
		usuarioService.actualizar(usuarioAux);
		mensaje(Constantes.MODIFICADO,usuarioAux.getNombre()+Constantes.ESPACIO+usuarioAux.getApellido());
	}
	public void borrar(Usuario usuario){
		usuarioService.borrar(usuario);
		mensaje(Constantes.BORRADO,usuario.getNombre()+Constantes.ESPACIO+usuario.getApellido());
	}
	public List<SelectItem> niveles(){
		return usuarioService.comboNiveles();
				
	}
	public List<Usuario> lista(){
		return usuarioService.lista();
	}
	public List<SelectItem> comboUsuarios(){
		return usuarioService.combo();
	}
	
	public void mensaje(String titulo, String mensaje) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(titulo, mensaje));
	}
	
}
