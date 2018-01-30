package punto.venta.service;

import java.util.List;

import punto.venta.model.Articulo;

public interface ArticuloService {
	void guardar(Articulo articulo);
	void actualizar(Articulo articulo);
	void borrar(Articulo articulo);
	Articulo buscarPorId(int id);
	Articulo buscarPorCodigo(String cod);
	List<Articulo> lista();
	
}
