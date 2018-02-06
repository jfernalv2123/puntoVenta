package punto.venta.dao;

import java.util.Date;
import java.util.List;

import punto.venta.model.Articulo;
import punto.venta.model.Venta;
import punto.venta.model.VentaArticulo;

public interface VentaArticuloDao {
	void guardar(VentaArticulo ventaArticulo);
	void actualizar(VentaArticulo ventaArticulo);
	VentaArticulo buscarPorId(int id);
	void borrar(VentaArticulo ventaArticulo);
	List<VentaArticulo> lista();
	List<VentaArticulo> listaPorVenta(Venta venta);
	List<VentaArticulo> listaPorArticulo(Articulo art );
	List<VentaArticulo> listaPorFechas(Date desde,Date hasta);
}
