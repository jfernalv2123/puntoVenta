package punto.venta.dao;

import java.util.List;

import punto.venta.model.Articulo;

public interface ArticuloDao {

	void guardar(Articulo articulo);
	void actualizar(Articulo articulo);
	Articulo buscarPorId(int id);
	void borrar(Articulo articulo);
	List<Articulo> lista();
	Articulo buscarPorCodigo(String cod);
	
}
