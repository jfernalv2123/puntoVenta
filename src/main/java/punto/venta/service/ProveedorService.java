package punto.venta.service;

import java.util.List;

import javax.faces.model.SelectItem;

import punto.venta.model.Proveedor;

public interface ProveedorService {
	void guardar(Proveedor proveedor);
	void actualizar(Proveedor proveedor);
	void borrar(Proveedor proveedor);
	Proveedor buscarPorId(int id);
	List<Proveedor> lista();
	List<SelectItem> combo();
}
