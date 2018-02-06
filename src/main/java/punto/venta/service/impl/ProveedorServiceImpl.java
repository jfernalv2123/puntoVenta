package punto.venta.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import punto.venta.constantes.Constantes;
import punto.venta.dao.ProveedorDao;
import punto.venta.model.Proveedor;
import punto.venta.service.ProveedorService;

@Service("proveedorService")
public class ProveedorServiceImpl implements ProveedorService{
	
	@Autowired
	ProveedorDao proveedorDao;
	
	@Transactional
	public void guardar(Proveedor proveedor) {
		proveedorDao.guardar(proveedor);
	}
	@Transactional
	public void actualizar(Proveedor proveedor) {
		proveedorDao.actualizar(proveedor);
	}
	@Transactional
	public void borrar(Proveedor proveedor) {
		proveedorDao.borrar(proveedor);
	}
	@Transactional
	public Proveedor buscarPorId(int id) {
		return proveedorDao.buscarPorId(id);
	}
	@Transactional
	public List<Proveedor> lista(){
		return proveedorDao.lista();
	}
	@Transactional
	public List<SelectItem> combo() {
		List<SelectItem> aux = new ArrayList<SelectItem>();
		SelectItem selec = new SelectItem();
		selec.setLabel(Constantes.SELECCIONE);
		selec.setValue(Constantes.CEROSTRING);
		aux.add(selec);
		for(Proveedor p:proveedorDao.lista()){
			SelectItem item = new SelectItem();
			item.setLabel(p.getNombre());
			item.setValue(p.getId());
			aux.add(item);
		}
		return aux;
	}
}
