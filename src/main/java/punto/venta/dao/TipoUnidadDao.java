package punto.venta.dao;

import java.util.List;

import punto.venta.model.TipoUnidad;

public interface TipoUnidadDao {
	void guardar(TipoUnidad tipoUnidad);
	void actualizar(TipoUnidad tipoUnidad);
	TipoUnidad buscarPorId(int id);
	void borrar(TipoUnidad tipoUnidad);
	List<TipoUnidad> lista();

}
