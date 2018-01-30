package punto.venta.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import punto.venta.service.ArticuloService;

@ManagedBean
@SessionScoped
public class ArticuloBean implements Serializable{

	@ManagedProperty(value="#{articuloService}")
	ArticuloService articuloService;

	public void setArticuloService(ArticuloService articuloService) {
		this.articuloService = articuloService;
	}
	
	
}
