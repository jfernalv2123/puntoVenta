package punto.venta.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.mapping.Array;

import punto.venta.constantes.Constantes;
import punto.venta.model.Articulo;
import punto.venta.model.IngresoArticulo;
import punto.venta.model.TipoArticulo;
import punto.venta.model.TipoUnidad;
import punto.venta.model.Usuario;
import punto.venta.model.VentaArticulo;
import punto.venta.service.ArticuloService;
import punto.venta.service.IngresoArticuloService;
import punto.venta.service.TipoUnidadService;
import punto.venta.service.UsuarioService;
import punto.venta.service.VentaArticuloService;

@ManagedBean
@SessionScoped
public class IngresoArticuloBean {

	@ManagedProperty(value = "#{usuarioService}")
	UsuarioService usuarioService;
	@ManagedProperty(value = "#{articuloService}")
	ArticuloService articuloService;
	@ManagedProperty(value = "#{tipoUnidadService}")
	TipoUnidadService tipoUnidadService;
	@ManagedProperty(value = "#{ingresoArticuloService}")
	IngresoArticuloService ingresoArticuloService;
	@ManagedProperty(value = "#{ventaArticuloService}")
	VentaArticuloService ventaArticuloService;
	
	private Articulo articulo;
	private Date fecha;
	private Integer cantidad;
	private Integer idTipounidad;
	private TipoUnidad unidad;
	private Integer valor;
	private Integer costo;
	private Integer idArticulo;
	private Usuario usuario;
	private Integer descuento;
	private boolean tipoDescuento;
	private Integer idTipo;
	private IngresoArticulo ingresoArticuloAux;
	private TipoUnidad tipoUnidad;
	private TipoArticulo tipoArticulo;
	private List<Articulo> listaArticuloAux=new ArrayList<Articulo>();
	private List<IngresoArticulo> listaIngresoArticuloAux= new ArrayList<IngresoArticulo>();
	
	
	public List<IngresoArticulo> getListaIngresoArticuloAux() {
		return listaIngresoArticuloAux;
	}
	public void setListaIngresoArticuloAux(List<IngresoArticulo> listaIngresoArticuloAux) {
		this.listaIngresoArticuloAux = listaIngresoArticuloAux;
	}
	
	public void setVentaArticuloService(VentaArticuloService ventaArticuloService) {
		this.ventaArticuloService = ventaArticuloService;
	}

	private String codigo;
	
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getIdTipounidad() {
		return idTipounidad;
	}
	public void setIdTipounidad(Integer idTipounidad) {
		this.idTipounidad = idTipounidad;
	}
	public TipoUnidad getUnidad() {
		return unidad;
	}
	public void setUnidad(TipoUnidad unidad) {
		this.unidad = unidad;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public Integer getCosto() {
		return costo;
	}
	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	public Integer getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	public void setArticuloService(ArticuloService articuloService) {
		this.articuloService = articuloService;
	}
	public void setTipoUnidadService(TipoUnidadService tipoUnidadService) {
		this.tipoUnidadService = tipoUnidadService;
	}
	public void setIngresoArticuloService(IngresoArticuloService ingresoArticuloService) {
		this.ingresoArticuloService = ingresoArticuloService;
	}
	public Integer getDescuento() {
		return descuento;
	}
	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}
	public boolean isTipoDescuento() {
		return tipoDescuento;
	}
	public void setTipoDescuento(boolean tipoDescuento) {
		this.tipoDescuento = tipoDescuento;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Integer getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}
	public List<Articulo> getListaArticuloAux() {
		return listaArticuloAux;
	}
	public void setListaArticuloAux(List<Articulo> listaArticuloAux) {
		this.listaArticuloAux = listaArticuloAux;
	}
	
	public IngresoArticulo getIngresoArticuloAux() {
		return ingresoArticuloAux;
	}
	public void setIngresoArticuloAux(IngresoArticulo ingresoArticuloAux) {
		this.ingresoArticuloAux = ingresoArticuloAux;
	}
	

	public void agregarArticulo(){
		Articulo art= new Articulo();
		IngresoArticulo ingArt =new IngresoArticulo();
		Date fechaActual= new Date();
		boolean tiene=false;
		if(!getCodigo().equals("")){
			art=articuloService.buscarPorCodigo(getCodigo());
			ingArt.setArticulo(art);
			ingArt.setCantidad(getCantidad());
			ingArt.setCosto(getCosto());
			ingArt.setValor(getValor());
			ingArt.setFecha(fechaActual);
			ingArt.setUsuario(usuarioService.buscarPorId(1));
			for(IngresoArticulo in:listaIngresoArticuloAux){
				if(in.getArticulo().getCodigo().equals(getCodigo())){
					tiene=true;
				}
			}
			if(!tiene){
				listaIngresoArticuloAux.add(ingArt);	
			}	
		}

	}
	public void guardarArticulo(){
		for(IngresoArticulo in:listaIngresoArticuloAux){
			ingresoArticuloService.guardar(in);
			mensaje(Constantes.GUARDADO, in.getArticulo().getArticulo());
		}
		listaIngresoArticuloAux.clear();
		
	}
	public List<IngresoArticulo> listaIngresos(){
		return ingresoArticuloService.lista();
	}
	public void borrarIngreso(IngresoArticulo ingr){
		ingresoArticuloService.borrar(ingr);
	}
	public void cargaIngreso(IngresoArticulo ing){
		ingresoArticuloAux=ing;
		
	}
	public void modificarIngreso(){
		ingresoArticuloService.actualizar(ingresoArticuloAux);
		mensaje(Constantes.MODIFICADO, ingresoArticuloAux.getArticulo().getArticulo());
	}
	public Integer stockArticulo(Articulo art){
		
		return ingresoArticuloService.stock(art);
	}
	public TipoUnidad getTipoUnidad() {
		return tipoUnidad;
	}
	public void setTipoUnidad(TipoUnidad tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}
	public TipoArticulo getTipoArticulo() {
		return tipoArticulo;
	}
	public void setTipoArticulo(TipoArticulo tipoArticulo) {
		this.tipoArticulo = tipoArticulo;
	}
	
	public void mensaje(String titulo, String mensaje) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(titulo, mensaje));
	}
	
	
	
}
