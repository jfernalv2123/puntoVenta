package municipalidad.pto.beans;

import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import municipalidad.pto.model.Articulos;
import municipalidad.pto.model.Facturas;
import municipalidad.pto.model.Ingreso;
import municipalidad.pto.model.Proveedor;
import municipalidad.pto.model.RelIngresoArticulo;
import municipalidad.pto.model.Ubicacion;
import municipalidad.pto.objetos.CantidadArticulos;
import municipalidad.pto.objetos.IngresoPrint;
import municipalidad.pto.service.ArticulosService;
import municipalidad.pto.service.FacturasService;
import municipalidad.pto.service.IngresoService;
import municipalidad.pto.service.ProveedorService;
import municipalidad.pto.service.RelIngresoArticuloService;
import municipalidad.pto.service.UbicacionService;

@ManagedBean
@SessionScoped
public class IngresoBean implements Serializable {

	@ManagedProperty(value="#{ingresoService}")
	IngresoService ingresoService;
	@ManagedProperty(value="#{proveedorService}")
	ProveedorService proveedorService;
	@ManagedProperty(value="#{articulosService}")
	ArticulosService articulosService;
	@ManagedProperty(value="#{relIngresoArticuloService}")
	RelIngresoArticuloService relIngresoArticuloService;
	@ManagedProperty(value="#{ubicacionService}")
	UbicacionService ubicacionService;
	@ManagedProperty(value="#{facturasService}")
	FacturasService facturasService;
	
	private Integer id;
	private Ingreso ingresoAux;
	private Integer ubicacion;
	private String Observacion;
	private Date fecha;
	private Integer proveedor;
	private String ordenDeCompra;
	private String factura;
	private String guiaDeDespacho;
	private String destino;
	private boolean inventariable;
	private String lugarAlmacenaje;
	private boolean conforme;
	private boolean prestamo;
	private Integer idArticulo;
	private Integer cantidad;
	private Ingreso ingreso;
	private Date fechaFactura;
	private Date fechaGuia;
	private Date hora;
	private Date fechaOrdenCompra;
	private String codigoAntiguo;
	private IngresoPrint ingresoPrint;
	private List<Articulos> listaArticulos;
	private List<CantidadArticulos> listaCantidadArticulos=new ArrayList<CantidadArticulos>();
	private List<RelIngresoArticulo> listaRelIngresoArticulo;
	private List<Ingreso> listaIngreso;
	private List<String> listFacturaAux=new ArrayList<String>();
	private List<Facturas> listFacturas=new ArrayList<Facturas>();
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setFacturasService(FacturasService facturasService) {
		this.facturasService = facturasService;
	}
	public void setUbicacionService(UbicacionService ubicacionService) {
		this.ubicacionService = ubicacionService;
	}
	public void setRelIngresoArticuloService(RelIngresoArticuloService relIngresoArticuloService) {
		this.relIngresoArticuloService = relIngresoArticuloService;
	}
	public void setArticulosService(ArticulosService articulosService) {
		this.articulosService = articulosService;
	}
	public void setProveedorService(ProveedorService proveedorService) {
		this.proveedorService = proveedorService;
	}
	public String getObservacion() {
		return Observacion;
	}
	public void setObservacion(String observacion) {
		Observacion = observacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getProveedor() {
		return proveedor;
	}
	public void setProveedor(Integer proveedor) {
		this.proveedor = proveedor;
	}
	public String getOrdenDeCompra() {
		return ordenDeCompra;
	}
	public void setOrdenDeCompra(String ordenDeCompra) {
		this.ordenDeCompra = ordenDeCompra;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public String getGuiaDeDespacho() {
		return guiaDeDespacho;
	}
	public void setGuiaDeDespacho(String guiaDeDespacho) {
		this.guiaDeDespacho = guiaDeDespacho;
	}
	public Integer getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public boolean isInventariable() {
		return inventariable;
	}
	public void setInventariable(boolean inventariable) {
		this.inventariable = inventariable;
	}
	public String getLugarAlmacenaje() {
		return lugarAlmacenaje;
	}
	public void setLugarAlmacenaje(String lugarAlmacenaje) {
		this.lugarAlmacenaje = lugarAlmacenaje;
	}
	public boolean isConforme() {
		return conforme;
	}
	public void setConforme(boolean conforme) {
		this.conforme = conforme;
	}
	public boolean isPrestamo() {
		return prestamo;
	}
	public void setPrestamo(boolean prestamo) {
		this.prestamo = prestamo;
	}
	public void setIngresoService(IngresoService ingresoService) {
		this.ingresoService = ingresoService;
	}
	
	public List<Articulos> getListaArticulos() {
		return listaArticulos;
	}
	public void setListaArticulos(List<Articulos> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}
	public Integer getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public List<CantidadArticulos> getListaCantidadArticulos() {
		return listaCantidadArticulos;
	}
	public void setListaCantidadArticulos(List<CantidadArticulos> listaCantidadArticulos) {
		this.listaCantidadArticulos = listaCantidadArticulos;
	}
	
	public List<RelIngresoArticulo> getListaRelIngresoArticulo() {
		return listaRelIngresoArticulo;
	}
	public void setListaRelIngresoArticulo(List<RelIngresoArticulo> listaRelIngresoArticulo) {
		this.listaRelIngresoArticulo = listaRelIngresoArticulo;
	}
	public List<RelIngresoArticulo> listaRelIngreso(){
		return relIngresoArticuloService.listaRelIngresoArticulo();
	}
	
	public List<Ingreso> getListaIngreso() {
		return listaIngreso;
	}
	public void setListaIngreso(List<Ingreso> listaIngreso) {
		this.listaIngreso = listaIngreso;
	}
	
	public Ingreso getIngreso() {
		return ingreso;
	}
	public void setIngreso(Ingreso ingreso) {
		this.ingreso = ingreso;
	}
	
	public Ingreso getIngresoAux() {
		return ingresoAux;
	}
	public void setIngresoAux(Ingreso ingresoAux) {
		this.ingresoAux = ingresoAux;
	}
	public IngresoPrint getIngresoPrint() {
		return ingresoPrint;
	}
	public void setIngresoPrint(IngresoPrint ingresoPrint) {
		this.ingresoPrint = ingresoPrint;
	}
	public List<String> getListFacturaAux() {
		return listFacturaAux;
	}
	public void setListFacturaAux(List<String> listFacturaAux) {
		this.listFacturaAux = listFacturaAux;
	}
	
	public List<Facturas> getListFacturas() {
		return listFacturas;
	}
	public void setListFacturas(List<Facturas> listFacturas) {
		this.listFacturas = listFacturas;
	}
	
	public Date getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	
	public Date getFechaGuia() {
		return fechaGuia;
	}
	public void setFechaGuia(Date fechaGuia) {
		this.fechaGuia = fechaGuia;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	public String getCodigoAntiguo() {
		return codigoAntiguo;
	}
	public void setCodigoAntiguo(String codigoAntiguo) {
		this.codigoAntiguo = codigoAntiguo;
	}
	
	public Date getFechaOrdenCompra() {
		return fechaOrdenCompra;
	}
	public void setFechaOrdenCompra(Date fechaOrdenCompra) {
		this.fechaOrdenCompra = fechaOrdenCompra;
	}
	public void Guardar(){
		Ingreso ingreso = new Ingreso();
		if(!getDestino().equals("")&&getFactura().equals("")
				&&getFecha().equals("")
				){
			
		}
		ingreso.setConforme(isConforme());
		ingreso.setDestino(getDestino());
		ingreso.setFecha(getFecha());
		ingreso.setGuiaDeDespacho(getGuiaDeDespacho());
		ingreso.setInventariable(isInventariable());
		ingreso.setObservacion(getObservacion());
		ingreso.setOrdenDeCompra(getOrdenDeCompra());
		ingreso.setFechaGuiaDespacho(getFechaGuia());
		ingreso.setPrestamo(isPrestamo());
		Time ho=new Time(getHora().getHours(), getHora().getMinutes(), getHora().getSeconds());
		ingreso.setHora(ho);
		ingreso.setFechaOrdenCompra(getFechaOrdenCompra());
		ingreso.setProveedor(proveedorService.findProveedorById(getProveedor()));
		ingreso.setUbicacion(ubicacionService.findUbicacionById(getUbicacion()));
		ingresoService.persistIngreso(ingreso);
		int idIngreso=ingresoService.ultimoIngreso();
		ingreso=ingresoService.findIngresoById(idIngreso);
		
		for(CantidadArticulos cantA : listaCantidadArticulos){
			RelIngresoArticulo relIngresoArticulo=new RelIngresoArticulo();
			
			relIngresoArticulo.setArticulo(cantA.getArticulo());
			relIngresoArticulo.setIngreso(ingreso);
			relIngresoArticulo.setCatidad(cantA.getCantidad());
			relIngresoArticuloService.persistRelIngresoArticulo(relIngresoArticulo);
		}
		for(Facturas fac:listFacturas){
			Facturas facturas= new Facturas();
			facturas.setFactura(fac.getFactura());
			facturas.setFecha(fac.getFecha());
			facturas.setIngreso(ingreso);
			facturasService.persistFacturas(facturas);
		}
		setDestino(null);
		setFactura(null);
		setGuiaDeDespacho(null);
		setLugarAlmacenaje(null);
		setObservacion(null);
		setOrdenDeCompra(null);
		listFacturaAux.clear();
		listaCantidadArticulos.clear();
		
	}
	public void mensaje(String titulo, String mensaje) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(titulo, mensaje));
	}
public void addFactura(){
	if(!factura.equals("")){
	if(listFacturaAux.contains(factura)){
		FacesMessage msg = new FacesMessage("ya ingresado", "La factura "+factura+" ya esta en lista");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}else{
		listFacturaAux.add(factura);
		
	}}
}
public void agregarFactura(){
	Facturas fac=new Facturas();
	if(!getFactura().equals("") &&!getFechaFactura().equals("")){
		if(listFacturas.contains(fac)){
			
		}else{
		fac.setFactura(getFactura());
		fac.setFecha(getFechaFactura());
		listFacturas.add(fac);
		}
		}
	
}
	public void addArticuloCantidad() {
		CantidadArticulos cantidadArticulos = new CantidadArticulos();
		boolean aux = true;
		if (getCantidad() != null) {
			Articulos art = articulosService.findArticuloByCodigo(getCodigoAntiguo());
			cantidadArticulos.setArticulo(art);
			cantidadArticulos.setCantidad(getCantidad());
			if (art != null) {
				for (CantidadArticulos cant : listaCantidadArticulos) {
					if (cant.getArticulo().getIdArticulos() == art.getIdArticulos()) {
						aux = false;
					}
				}
				if (aux) {
					listaCantidadArticulos.add(cantidadArticulos);
				} else {
					mensaje("Ya Existe ", art.getArticulo());

				}

			}
		}
	}

	public void onRowEdit(RowEditEvent event) {
		
	}
	public void onRowCancel(RowEditEvent event) {
		mensaje("Cancelada", ((RelIngresoArticulo) event.getObject()).getIngreso().getOrdenDeCompra());
	}
	public void borrar(int id){
		mensaje("borrado", relIngresoArticuloService.findRelIngresoArticuloById(id).getArticulo().getArticulo());
		
		relIngresoArticuloService.deleteRelIngresoArticulo(relIngresoArticuloService.findRelIngresoArticuloById(id));
	}
	public List<Ingreso> listaDeIngresos(){
		return ingresoService.listaIngresos();
	}
	public void borrarIngreso(int id){
		for(RelIngresoArticulo reAux:relIngresoArticuloService.listaRelIngresoArticuloByIngreso(id)){
			relIngresoArticuloService.deleteRelIngresoArticulo(reAux);
		}
		for(Facturas fac:facturasService.listaFacturasByIngreso(id)){
			facturasService.deleteFacturas(fac);
		}
		ingresoService.deleteIngreso(ingresoService.findIngresoById(id));
		mensaje("Borrado","el ingreso se ha borrado");
	}
	public List<RelIngresoArticulo> listaRelIngresoArticuloByIngreso(int id){
		
		ingreso=ingresoService.findIngresoById(id);
		return listaRelIngresoArticulo=relIngresoArticuloService.listaRelIngresoArticuloByIngreso(id);
		
	}
	public void modificar(Ingreso ingreso){
		ingresoAux=ingreso;
		setHora(ingresoAux.getHora());
		listaRelIngresoArticulo=relIngresoArticuloService.listaRelIngresoArticuloByIngreso(ingreso.getIdIngreso());
	}
	public void removeArticuloIngreso(RelIngresoArticulo rl){
		relIngresoArticuloService.deleteRelIngresoArticulo(rl);
	}
	public void addArticuloIngresoMod(){
		RelIngresoArticulo rel=new RelIngresoArticulo();
		
		rel.setIngreso(ingresoAux);
		try {
			rel.setArticulo(articulosService.findArticuloByCodigo(getCodigoAntiguo()));
			rel.setCatidad(getCantidad());
			relIngresoArticuloService.persistRelIngresoArticulo(rel);
			listaRelIngresoArticulo.clear();
			listaRelIngresoArticulo=relIngresoArticuloService.listaRelIngresoArticuloByIngreso(ingresoAux.getIdIngreso());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void guardarIngreso(){
		Time ho=new Time(getHora().getHours(), getHora().getMinutes(), getHora().getSeconds());
		ingresoAux.setHora(ho);
		ingresoService.updateIngreso(ingresoAux);
		System.out.println(ingresoAux.getDestino());
	}
	public String afirmacion(boolean s){
		String si="No";
		if(s){
			si="Si";
		}
		return si;
	}
	public List<Facturas> listaFacturasByIngreso(int id){
		return facturasService.listaFacturasByIngreso(id);
	}
	public List<Facturas> listaFacturas(){
		return facturasService.listaFacturas();
	}
    public String horaActual(){
        String myDatePattern1 = "HH:mm:ss";
        Date fecha = new Date();
        SimpleDateFormat df = new SimpleDateFormat( myDatePattern1 );
        
     return df.format( fecha );
       
}
    public String formatearFecha(Date fecha){
        String myDatePattern1 = "dd/MM/yyyy";
        
        SimpleDateFormat df = new SimpleDateFormat( myDatePattern1 );
        if(fecha!=null){
        	return df.format( fecha );
        }else{
        	return "";
        }
     
    }
    
}