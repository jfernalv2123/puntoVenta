package punto.venta.dao;

import java.util.List;

import punto.venta.model.IngresoArticulo;

public interface IngresoArticuloDao {
	void guardar(IngresoArticulo ingresoArticulo);
	void actualizar(IngresoArticulo ingresoArticulo);
	IngresoArticulo buscarPorId(int id);
	void borrar(IngresoArticulo ingresoArticulo);
	List<IngresoArticulo> lista();
}
