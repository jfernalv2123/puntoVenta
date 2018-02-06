package punto.venta.service;

import java.util.List;

import punto.venta.model.Venta;

public interface VentaService {
	void guardar(Venta venta);
	void actualizar(Venta venta);
	void borrar(Venta venta);
	Venta buscarPorId(int id);
	List<Venta> lista();
	Venta ultimaVenta();
}
