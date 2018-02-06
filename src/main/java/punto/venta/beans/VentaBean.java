package punto.venta.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import punto.venta.constantes.Constantes;
import punto.venta.model.Articulo;
import punto.venta.model.IngresoArticulo;
import punto.venta.model.Usuario;
import punto.venta.model.Venta;
import punto.venta.model.VentaArticulo;
import punto.venta.service.ArticuloService;
import punto.venta.service.IngresoArticuloService;
import punto.venta.service.UsuarioService;
import punto.venta.service.VentaArticuloService;
import punto.venta.service.VentaService;

@ManagedBean
@SessionScoped
public class VentaBean {

	@ManagedProperty(value = "#{usuarioService}")
	UsuarioService usuarioService;
	@ManagedProperty(value = "#{articuloService}")
	ArticuloService articuloService;
	@ManagedProperty(value = "#{ventaService}")
	VentaService ventaService;
	@ManagedProperty(value = "#{ventaArticuloService}")
	VentaArticuloService ventaArticuloService;
	@ManagedProperty(value = "#{ingresoArticuloService}")
	IngresoArticuloService ingresoArticuloService;
	
	private String rut;
	private Date fecha;
	private Integer descuento;
	private boolean tipoDescuento;
	private Integer idArticulo;
	private String codigoArticulo;
	private Integer cantidad;
	private Integer precio;
	private Date desde;
	private Date hasta;
	private List<VentaArticulo> listaVentaArticuloAux=new ArrayList<VentaArticulo>();
	private List<VentaArticulo> listaVentaArticuloAux2=new ArrayList<VentaArticulo>();
	private Integer total=0;
	
	public ArticuloService getArticuloService() {
		return articuloService;
	}
	public void setArticuloService(ArticuloService articuloService) {
		this.articuloService = articuloService;
	}
	
	public void setIngresoArticuloService(IngresoArticuloService ingresoArticuloService) {
		this.ingresoArticuloService = ingresoArticuloService;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	public Integer getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	public void setVentaService(VentaService ventaService) {
		this.ventaService = ventaService;
	}
	public void setVentaArticuloService(VentaArticuloService ventaArticuloService) {
		this.ventaArticuloService = ventaArticuloService;
	}
	public List<VentaArticulo> getListaVentaArticuloAux() {
		return listaVentaArticuloAux;
	}
	public void setListaVentaArticuloAux(List<VentaArticulo> listaVentaArticuloAux) {
		this.listaVentaArticuloAux = listaVentaArticuloAux;
	}
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
	public Date getDesde() {
		return desde;
	}
	public void setDesde(Date desde) {
		this.desde = desde;
	}
	public Date getHasta() {
		return hasta;
	}
	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public void cargaListaArticulo(){
		VentaArticulo ventaArticulo=new VentaArticulo();
		Articulo art=articuloService.buscarPorCodigo(getCodigoArticulo());
		
		
		if(!getCodigoArticulo().equals(Constantes.VACIO)&& !getCantidad().equals(Constantes.VACIO)){
			Integer stock=ingresoArticuloService.stock(art);
			for(VentaArticulo ve:listaVentaArticuloAux){
				if(art.getCodigo().equals(ve.getArticulo().getCodigo())){
					stock=stock-ve.getCantidad();
				}
				
			}

				
				if(stock>=getCantidad()){
					ventaArticulo.setCantidad(getCantidad());
					ventaArticulo.setArticulo(art);
					ventaArticulo.setPrecio(ingresoArticuloService.ultimoIngresoPorArticulo(art).getValor());
					listaVentaArticuloAux.add(ventaArticulo);
				}else{
					mensaje(Constantes.STOCK_INSUFICIENTE, ingresoArticuloService.stock(art).toString());
				}
			

		}
		
		
	}
	public void cargaPrecio(Articulo art){
		IngresoArticulo ingA=ingresoArticuloService.ultimoIngresoPorArticulo(art);
		setPrecio(ingA.getValor());
		
	}
	public List<VentaArticulo> getListaVentaArticuloAux2() {
		return listaVentaArticuloAux2;
	}
	public void setListaVentaArticuloAux2(List<VentaArticulo> listaVentaArticuloAux2) {
		this.listaVentaArticuloAux2 = listaVentaArticuloAux2;
	}
	public void venta(){
		Venta venta=new Venta();
		Date fecha= new Date();
		venta.setDescuento(0);
		venta.setFecha(fecha);
		venta.setTipoDescuento(false);
		venta.setUsuario(usuarioService.buscarPorId(1));
		if(listaVentaArticuloAux.size()>0){
			ventaService.guardar(venta);
			for(VentaArticulo ven:listaVentaArticuloAux){
				ven.setVenta(ventaService.ultimaVenta());
				ventaArticuloService.guardar(ven);
			}
		
		}
		listaVentaArticuloAux.clear();
	}
	public Integer totalVenta(){
		Integer total=0;
		for(VentaArticulo ven:listaVentaArticuloAux){
			total += (ven.getCantidad()*ven.getPrecio());
		}
		return total;
	}
	public List<Venta> listaVentas(){
		return ventaService.lista();
	}
	public void cargaListaIngreso(Venta venta){
		listaVentaArticuloAux2=ventaArticuloService.listaPorVenta(venta);
	}
	public String tipoDescuento(boolean b){
		String tipo=Constantes.SIGNOPESO;
		if(b){
			tipo=Constantes.PORCENTAGE;
		}
		return tipo;
	}
	public void mensaje(String titulo, String mensaje) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(titulo, mensaje));
	}
	public void cargaListaPorFecha(){
		listaVentaArticuloAux=ventaArticuloService.listaPorFechas(getDesde(), getHasta());
		this.total=0;
		for(VentaArticulo ve:listaVentaArticuloAux){
			this.total+=ve.getPrecio();
		}
	}
}
