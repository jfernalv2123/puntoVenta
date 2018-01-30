package municipalidad.pto.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import municipalidad.pto.model.Articulos;
import municipalidad.pto.model.Devolucion;
import municipalidad.pto.model.RelSalidaArticulo;
import municipalidad.pto.model.Salida;
import municipalidad.pto.model.User;
import municipalidad.pto.objetos.CantidadArticulos;
import municipalidad.pto.service.ArticulosService;
import municipalidad.pto.service.DevolucionService;
import municipalidad.pto.service.RelSalidaArticuloService;
import municipalidad.pto.service.SalidaService;
import municipalidad.pto.service.UbicacionService;
import municipalidad.pto.service.UserService;

@ManagedBean
@SessionScoped
public class SalidaBean {

	@ManagedProperty(value = "#{salidaService}")
	SalidaService salidaService;
	@ManagedProperty(value = "#{articulosService}")
	ArticulosService articulosService;
	@ManagedProperty(value = "#{ubicacionService}")
	UbicacionService ubicacionService;
	@ManagedProperty(value = "#{relSalidaArticuloService}")
	RelSalidaArticuloService relSalidaArticuloService;
	@ManagedProperty(value = "#{userService}")
	UserService userService;
	@ManagedProperty(value = "#{devolucionService}")
	DevolucionService devolucionService;
	private Integer id;
	private Salida salida;
	private String Solicitante;
	private String numeroSolicitud;
	private String numeroSalida;
	private String observacion;
	private Date fecha;
	private boolean prestamo;
	private Integer cantidad;
	private Integer idArticulo;
	private Integer ubicacion;
	private String codigoAntiguo;
	private List<Articulos> listaArticulos;
	private List<CantidadArticulos> listaCantidadArticulos = new ArrayList<CantidadArticulos>();
	private List<CantidadArticulos> listaCantidadArticulosAux = new ArrayList<CantidadArticulos>();
	private List<RelSalidaArticulo> listaRelSalida;
	private List<Salida> listaSalidaAux;
	private List<Articulos> listArticuloAux = new ArrayList<Articulos>();
	private List<Devolucion> listaDevolucionAux;
	private User user;
	private String destino;

	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setSalidaService(SalidaService salidaService) {
		this.salidaService = salidaService;
	}

	public void setArticulosService(ArticulosService articulosService) {
		this.articulosService = articulosService;
	}

	public void setUbicacionService(UbicacionService ubicacionService) {
		this.ubicacionService = ubicacionService;
	}

	public void setRelSalidaArticuloService(RelSalidaArticuloService relSalidaArticuloService) {
		this.relSalidaArticuloService = relSalidaArticuloService;
	}

	public void setDevolucionService(DevolucionService devolucionService) {
		this.devolucionService = devolucionService;
	}

	public Salida getSalida() {
		return salida;
	}

	public void setSalida(Salida salida) {
		this.salida = salida;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSolicitante() {
		return Solicitante;
	}

	public void setSolicitante(String solicitante) {
		Solicitante = solicitante;
	}

	public String getNumeroSolicitud() {
		return numeroSolicitud;
	}

	public void setNumeroSolicitud(String numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}

	public String getNumeroSalida() {
		return numeroSalida;
	}

	public void setNumeroSalida(String numeroSalida) {
		this.numeroSalida = numeroSalida;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isPrestamo() {
		return prestamo;
	}

	public void setPrestamo(boolean prestamo) {
		this.prestamo = prestamo;
	}

	public List<Articulos> getListaArticulos() {
		return listaArticulos;
	}

	public void setListaArticulos(List<Articulos> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}

	public List<CantidadArticulos> getListaCantidadArticulos() {
		return listaCantidadArticulos;
	}

	public void setListaCantidadArticulos(List<CantidadArticulos> listaCantidadArticulos) {
		this.listaCantidadArticulos = listaCantidadArticulos;
	}

	public List<RelSalidaArticulo> getListaRelSalida() {
		return listaRelSalida;
	}

	public void setListaRelSalida(List<RelSalidaArticulo> listaRelSalida) {
		this.listaRelSalida = listaRelSalida;
	}

	public List<Salida> getListaSalidaAux() {
		return listaSalidaAux;
	}

	public void setListaSalidaAux(List<Salida> listaSalidaAux) {
		this.listaSalidaAux = listaSalidaAux;
	}

	public List<Salida> listaSalida() {
		return salidaService.listaSalidas();
	}

	public List<Devolucion> getListaDevolucionAux() {
		return listaDevolucionAux;
	}

	public void setListaDevolucionAux(List<Devolucion> listaDevolucionAux) {
		this.listaDevolucionAux = listaDevolucionAux;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public void mensaje(String titulo, String mensaje) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(titulo, mensaje));
	}

	public List<Articulos> getListArticuloAux() {
		return listArticuloAux;
	}

	public void setListArticuloAux(List<Articulos> listArticuloAux) {
		this.listArticuloAux = listArticuloAux;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}

	public Integer getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<CantidadArticulos> getListaCantidadArticulosAux() {
		return listaCantidadArticulosAux;
	}

	public void setListaCantidadArticulosAux(List<CantidadArticulos> listaCantidadArticulosAux) {
		this.listaCantidadArticulosAux = listaCantidadArticulosAux;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getCodigoAntiguo() {
		return codigoAntiguo;
	}

	public void setCodigoAntiguo(String codigoAntiguo) {
		this.codigoAntiguo = codigoAntiguo;
	}

	public void addArticuloCantidad() {
		CantidadArticulos cantidadArticulos = new CantidadArticulos();
		boolean aux = true;
		if (getCantidad() != null) {
			Articulos art = articulosService.findArticuloByCodigo(getCodigoAntiguo());
			cantidadArticulos.setArticulo(art);
			cantidadArticulos.setCantidad(getCantidad());
			Long stock = articulosService.stock(art.getIdArticulos(), true);
			if (stock > cantidadArticulos.getCantidad()) {
				if (art != null) {
					for (CantidadArticulos cant : listaCantidadArticulos) {
						if (cant.getArticulo().getIdArticulos() == art.getIdArticulos()) {
							aux = false;
						}
					}
					if (aux) {
						listaCantidadArticulos.add(cantidadArticulos);
					} else {
						mensaje("Ya Existe", art.getArticulo());

					}

				}
			} else {
				mensaje("No Existe Stock Suficiente", "solo quedan " + stock + " "
						+ art.getUnidadMedida().getUnidadMedida() + " de " + art.getArticulo());
			}

		}
	}

	public void guardarSalida() {
		Salida salidaAux = new Salida();
		salidaAux.setDestino(getDestino());
		salidaAux.setFecha(getFecha());
		salidaAux.setnSalida(getNumeroSalida());
		salidaAux.setnSolicitud(getNumeroSolicitud());
		salidaAux.setObservaciones(getObservacion());
		salidaAux.setPrestamo(isPrestamo());
		salidaAux.setSolicitante(getSolicitante());
		salidaAux.setUbicacion(ubicacionService.findUbicacionById(getUbicacion()));

		salidaService.persistSalida(salidaAux);
		salidaAux = salidaService.findSalidaById(salidaService.ultimoIngreso());
		for (CantidadArticulos catAux : listaCantidadArticulos) {
			RelSalidaArticulo relSalidaAux = new RelSalidaArticulo();
			relSalidaAux.setArticulo(catAux.getArticulo());
			relSalidaAux.setCantidad(catAux.getCantidad());
			relSalidaAux.setSalida(salidaAux);
			relSalidaArticuloService.persistRelSalidaArticulo(relSalidaAux);
		}
		listaCantidadArticulosAux.clear();
	}

	public List<RelSalidaArticulo> listaSalidaArticuloBySalida(int id) {
		List<RelSalidaArticulo> aux = relSalidaArticuloService.listaRelSalidaArticuloByIngreso(id);
		for (RelSalidaArticulo relsal : aux) {
			salida = relsal.getSalida();
		}
		return aux;
	}

	public void borrarSalida(int id) {
		for (RelSalidaArticulo relSalAux : relSalidaArticuloService.listaRelSalidaArticuloByIngreso(id)) {
			relSalidaArticuloService.deleteRelSalidaArticulo(relSalAux);
		}
		try {
			for(Devolucion d:devolucionService.listaDevolucionBySalida(id)){
				devolucionService.deleteDevolucion(d);
			}
		} catch (Exception e) {
			System.out.println("no existen devoluciones");
			
		}
		
		salidaService.deleteSalida(salidaService.findSalidaById(id));
	}

	public void modificar(Salida sal) {
		salida = sal;
	}

	public void guardarSalidaMod() {
		salidaService.updateSalida(salida);
	}

	public String afirmacion(boolean s) {
		String si = "No";
		if (s) {
			si = "Si";
		}
		return si;
	}

	public void cargarListaDevolucion(Salida sal) {
		listaCantidadArticulos.clear();
		listArticuloAux.clear();
		listaCantidadArticulosAux.clear();
		for (RelSalidaArticulo rsa : relSalidaArticuloService.listaRelSalidaArticuloByIngreso(sal.getIdSalida())) {
			CantidadArticulos cant = new CantidadArticulos();
			Long devuelto=0L;
			Long perdida=0L;
			if(devolucionService.salidaDevolucionBySalidaAndArticulo(rsa.getSalida().getIdSalida(), rsa.getArticulo().getIdArticulos(),false)!=null){
				devuelto=devolucionService.salidaDevolucionBySalidaAndArticulo(rsa.getSalida().getIdSalida(), rsa.getArticulo().getIdArticulos(),false);
			}
			if(devolucionService.salidaDevolucionBySalidaAndArticulo(rsa.getSalida().getIdSalida(), rsa.getArticulo().getIdArticulos(),true)!=null){
				perdida=devolucionService.salidaDevolucionBySalidaAndArticulo(rsa.getSalida().getIdSalida(), rsa.getArticulo().getIdArticulos(),true);
			}
			if((rsa.getCantidad()-devuelto.intValue()-perdida.intValue())!=0){
				cant.setArticulo(rsa.getArticulo());
				cant.setCantidad((rsa.getCantidad()-devuelto.intValue()-perdida.intValue()));
				listaCantidadArticulos.add(cant);
			}
			
		}

		salida = sal;
	}

	public void devolver() {
		
		for(CantidadArticulos cant:listaCantidadArticulosAux){
			Devolucion devolucion=new Devolucion();
			devolucion.setObservacion(getObservacion());
			devolucion.setArticulo(cant.getArticulo());
			devolucion.setCantidad(cant.getCantidad());
			devolucion.setSalida(getSalida());
			devolucion.setPerdida(isPrestamo());
			devolucionService.persistDevolucion(devolucion);
		}
		mensaje("Devuelto Por", getSalida().getSolicitante());
	}

	public void addArticuloCantidadDevolucion(CantidadArticulos cantArt) {
		boolean contiene = true;
		for (CantidadArticulos c : listaCantidadArticulosAux) {
			if (cantArt.getArticulo().getIdArticulos() == c.getArticulo().getIdArticulos()) {
				contiene = false;
			}
		}

		if (contiene) {

			listaCantidadArticulosAux.add(cantArt);
			listaCantidadArticulos.remove(cantArt);
			mensaje("Chequeado", cantArt.getArticulo().getArticulo());
		} else {
			mensaje("Ya Chequeado", cantArt.getArticulo().getArticulo());
		}

	}
	public boolean devuelto(boolean prestamo,int id){
		boolean devolver=true;
		Long devueltos=0L;
		Long perdidos=0L;
		Long salidas=0L;
		if(devolucionService.salidaDevolucionBySalida(id,false)!=null){
			devueltos=devolucionService.salidaDevolucionBySalida(id,false);
		}
		if(devolucionService.salidaDevolucionBySalida(id,true)!=null){
			perdidos=devolucionService.salidaDevolucionBySalida(id,true);
		}
		if(relSalidaArticuloService.salidaArticuloBySalida(id)!=null){
			salidas=relSalidaArticuloService.salidaArticuloBySalida(id);
		}
		
		if(prestamo && ((devueltos+perdidos)==salidas)){
			devolver=false;
		}
		
		return devolver;
	}
	public List<Devolucion> listaDevolucionesYPerdidas(){
		return devolucionService.listaDevolucion();
	}
	public boolean ocultar(int cantidad){
		if(cantidad==0){
			return false;
		}else{
			return true;
		}
	}
	public void borrarDevolucion(Devolucion de){
		devolucionService.deleteDevolucion(de);
	}
}
