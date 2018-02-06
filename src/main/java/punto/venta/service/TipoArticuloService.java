package punto.venta.service;

import java.util.List;

import javax.faces.model.SelectItem;

import punto.venta.model.TipoArticulo;

public interface TipoArticuloService {
	void guardar(TipoArticulo tipoArticulo);
	void actualizar(TipoArticulo tipoArticulo);
	void borrar(TipoArticulo tipoArticulo);
	TipoArticulo buscarPorId(int id);
	List<TipoArticulo> lista();
	List<SelectItem> combo();
}
