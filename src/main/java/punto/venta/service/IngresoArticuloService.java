package punto.venta.service;

import java.util.List;

import punto.venta.model.IngresoArticulo;

public interface IngresoArticuloService {
	void guardar(IngresoArticulo ingresoArticulo);
	void actualizar(IngresoArticulo ingresoArticulo);
	void borrar(IngresoArticulo ingresoArticulo);
	IngresoArticulo buscarPorId(int id);
	List<IngresoArticulo> lista();
}
