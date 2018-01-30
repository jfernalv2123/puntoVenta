package punto.venta.dao;

import java.util.List;

import punto.venta.model.VentaArticulo;

public interface VentaArticuloDao {
	void guardar(VentaArticulo ventaArticulo);
	void actualizar(VentaArticulo ventaArticulo);
	VentaArticulo buscarPorId(int id);
	void borrar(VentaArticulo ventaArticulo);
	List<VentaArticulo> lista();
}
