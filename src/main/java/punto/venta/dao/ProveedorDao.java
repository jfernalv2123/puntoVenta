package punto.venta.dao;

import java.util.List;

import punto.venta.model.IngresoArticulo;
import punto.venta.model.Proveedor;

public interface ProveedorDao {
	void guardar(Proveedor proveedor);
	void actualizar(Proveedor proveedor);
	Proveedor buscarPorId(int id);
	void borrar(Proveedor proveedor);
	List<Proveedor> lista();
}
