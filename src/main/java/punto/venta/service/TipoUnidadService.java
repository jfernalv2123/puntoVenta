package punto.venta.service;

import java.util.List;

import javax.faces.model.SelectItem;

import punto.venta.model.TipoUnidad;

public interface TipoUnidadService {

	void guardar(TipoUnidad tipoArticulo);
	void actualizar(TipoUnidad tipoArticulo);
	void borrar(TipoUnidad tipoArticulo);
	TipoUnidad buscarPorId(int id);
	List<TipoUnidad> lista();
	List<SelectItem> combo();
}
