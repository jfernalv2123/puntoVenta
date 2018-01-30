package punto.venta.dao;

import java.util.List;

import punto.venta.model.TipoArticulo;

public interface TipoArticuloDao {
	void guardar(TipoArticulo tipoArticulo);
	void actualizar(TipoArticulo tipoArticulo);
	TipoArticulo buscarPorId(int id);
	void borrar(TipoArticulo tipoArticulo);
	List<TipoArticulo> lista();
}
