package punto.venta.service;

import java.util.Date;
import java.util.List;

import punto.venta.model.Articulo;
import punto.venta.model.Venta;
import punto.venta.model.VentaArticulo;

public interface VentaArticuloService {
	void guardar(VentaArticulo ventaArticulo);
	void actualizar(VentaArticulo ventaArticulo);
	void borrar(VentaArticulo ventaArticulo);
	VentaArticulo buscarPorId(int id);
	List<VentaArticulo> lista();
	List<VentaArticulo> listaPorVenta(Venta venta);
	List<VentaArticulo> listaPorArticulo(Articulo art );
	List<VentaArticulo> listaPorFechas(Date desde,Date hasta );
}
