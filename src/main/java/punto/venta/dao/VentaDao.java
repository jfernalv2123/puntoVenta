package punto.venta.dao;

import java.util.List;

import punto.venta.model.Venta;

public interface VentaDao {
	void guardar(Venta venta);
	void actualizar(Venta venta);
	Venta buscarPorId(int id);
	void borrar(Venta venta);
	List<Venta> lista();
	Integer ultimaVenta();
}
