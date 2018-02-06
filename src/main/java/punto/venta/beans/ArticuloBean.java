package punto.venta.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import punto.venta.constantes.Constantes;
import punto.venta.model.Articulo;
import punto.venta.model.Proveedor;
import punto.venta.model.TipoArticulo;
import punto.venta.model.TipoUnidad;
import punto.venta.service.ArticuloService;
import punto.venta.service.ProveedorService;
import punto.venta.service.TipoArticuloService;
import punto.venta.service.TipoUnidadService;

@ManagedBean
@SessionScoped
public class ArticuloBean {

	@ManagedProperty(value = "#{articuloService}")
	ArticuloService articuloService;
	@ManagedProperty(value = "#{proveedorService}")
	ProveedorService proveedorService;
	@ManagedProperty(value = "#{tipoArticuloService}")
	TipoArticuloService tipoArticuloService;
	@ManagedProperty(value = "#{tipoUnidadService}")
	TipoUnidadService tipoUnidadService;

	public void setArticuloService(ArticuloService articuloService) {
		this.articuloService = articuloService;
	}

	public void setProveedorService(ProveedorService proveedorService) {
		this.proveedorService = proveedorService;
	}

	public void setTipoArticuloService(TipoArticuloService tipoArticuloService) {
		this.tipoArticuloService = tipoArticuloService;
	}

	public void setTipoUnidadService(TipoUnidadService tipoUnidadService) {
		this.tipoUnidadService = tipoUnidadService;
	}

	private Integer id;
	private String codigo;
	private String articulo;
	private String marca;
	private Proveedor proveedor;
	private Integer idProveedor;
	private TipoArticulo tipo;
	private Integer idTipo;
	private Articulo articuloAux;
	private Integer idTipoUnidad;
	private TipoUnidad tipoUnidad;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public TipoArticulo getTipo() {
		return tipo;
	}

	public void setTipo(TipoArticulo tipo) {
		this.tipo = tipo;
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public Articulo getArticuloAux() {
		return articuloAux;
	}

	public void setArticuloAux(Articulo articuloAux) {
		this.articuloAux = articuloAux;
	}

	public Integer getIdTipoUnidad() {
		return idTipoUnidad;
	}

	public void setIdTipoUnidad(Integer idTipoUnidad) {
		this.idTipoUnidad = idTipoUnidad;
	}

	public TipoUnidad getTipoUnidad() {
		return tipoUnidad;
	}

	public void setTipoUnidad(TipoUnidad tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}

	public void guardar() {
		Articulo articulo = new Articulo();
		articulo.setArticulo(getArticulo());
		articulo.setCodigo(getCodigo());
		articulo.setMarca(getMarca());
		articulo.setTipoUnidad(tipoUnidadService.buscarPorId(getIdTipoUnidad()));
		articulo.setProveedor(proveedorService.buscarPorId(getIdProveedor()));
		articulo.setTipo(tipoArticuloService.buscarPorId(getIdTipo()));
		articuloService.guardar(articulo);
		mensaje(Constantes.GUARDADO, articulo.getArticulo());
		setArticulo(null);
		setCodigo(null);
		setMarca(null);
		setIdTipo(null);
		setIdTipoUnidad(null);
		setIdProveedor(null);
	}
	public void cargaArticulo(Articulo art){
		this.articuloAux=art;
		
	}
	public void modificarArticulo(){
		articuloService.actualizar(articuloAux);
		mensaje(Constantes.MODIFICADO, articuloAux.getArticulo());
	}
	public void borrar(Articulo art){
		articuloService.borrar(art);
		mensaje(Constantes.BORRADO, art.getArticulo());
	}

	public List<Articulo> listaArticulos() {
		return articuloService.lista();
	}

	public void mensaje(String titulo, String mensaje) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(titulo, mensaje));
	}
	
}
