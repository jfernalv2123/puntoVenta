package prueba.data;

import javax.faces.bean.ManagedProperty;

import punto.venta.model.Tipo;
import punto.venta.service.TipoService;

public class Test {
	@ManagedProperty(value="#{tipoService}")
	TipoService tipoService;
	


	public void setTipoService(TipoService tipoService) {
		this.tipoService = tipoService;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Tipo tipo=new Tipo();
tipo.setIdTipo(5);

	}

}
