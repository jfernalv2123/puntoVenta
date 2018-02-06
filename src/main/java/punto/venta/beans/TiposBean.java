package punto.venta.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import punto.venta.constantes.Constantes;
import punto.venta.model.TipoArticulo;
import punto.venta.model.TipoUnidad;
import punto.venta.service.TipoArticuloService;
import punto.venta.service.TipoUnidadService;

@ManagedBean
@SessionScoped
public class TiposBean {

	@ManagedProperty(value = "#{tipoArticuloService}")
	TipoArticuloService tipoArticuloService;
	@ManagedProperty(value = "#{tipoUnidadService}")
	TipoUnidadService tipoUnidadService;
	
	public void setTipoArticuloService(TipoArticuloService tipoArticuloService) {
		this.tipoArticuloService = tipoArticuloService;
	}
	public void setTipoUnidadService(TipoUnidadService tipoUnidadService) {
		this.tipoUnidadService = tipoUnidadService;
	}
	
	private String tipo;
	private TipoUnidad tipoUnidadAux;
	private TipoArticulo tipoArticuloAux;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public TipoUnidad getTipoUnidadAux() {
		return tipoUnidadAux;
	}
	public void setTipoUnidadAux(TipoUnidad tipoUnidadAux) {
		this.tipoUnidadAux = tipoUnidadAux;
	}
	public TipoArticulo getTipoArticuloAux() {
		return tipoArticuloAux;
	}
	public void setTipoArticuloAux(TipoArticulo tipoArticuloAux) {
		this.tipoArticuloAux = tipoArticuloAux;
	}
	
	public void guardarTipoUnidad(){
		TipoUnidad tipo=new TipoUnidad();
		tipo.setTipo(getTipo());
		tipoUnidadService.guardar(tipo);
		mensaje(Constantes.GUARDADO,tipo.getTipo());
	}
	public void guardarTipoArticulo(){
		TipoArticulo tipo=new TipoArticulo();
		tipo.setTipo(getTipo());
		tipoArticuloService.guardar(tipo);
		mensaje(Constantes.GUARDADO,tipo.getTipo());
	}
	public void mensaje(String titulo, String mensaje) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(titulo, mensaje));
	}
	public void cargaUnidad(TipoUnidad tipo){
		tipoUnidadAux=tipo;
	}
	public void cargaArtculo(TipoArticulo tipo){
		tipoArticuloAux=tipo;
	}
	public void modificarTipoUnidad(){
		tipoUnidadService.actualizar(tipoUnidadAux);
		mensaje(Constantes.MODIFICADO,tipoUnidadAux.getTipo());
	}
	public void modificarTipoArticulo(){
		tipoArticuloService.actualizar(tipoArticuloAux);
		mensaje(Constantes.MODIFICADO,tipoArticuloAux.getTipo());
	}
	public List<TipoArticulo> listaTipoArticulo(){
		return tipoArticuloService.lista();
	}
	public List<TipoUnidad> listaTipoUnidad(){
		return tipoUnidadService.lista();
	}
	public List<SelectItem> comboTipoArticulo(){
		return tipoArticuloService.combo();
	}
	public List<SelectItem> comboTipoUnidad(){
		return tipoUnidadService.combo();
	}
	public void borrarTipoArticulo(TipoArticulo tipo){
		tipoArticuloService.borrar(tipo);
	}
	public void borrarTipoUnidad(TipoUnidad tipo){
		tipoUnidadService.borrar(tipo);
	}
}
