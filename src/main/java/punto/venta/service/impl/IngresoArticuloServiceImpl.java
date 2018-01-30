package punto.venta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import punto.venta.dao.IngresoArticuloDao;
import punto.venta.model.IngresoArticulo;
import punto.venta.service.IngresoArticuloService;
@Repository("ingresoArticuloService")
public class IngresoArticuloServiceImpl implements IngresoArticuloService {

	@Autowired
	IngresoArticuloDao ingresoArticuloDao;
	
	@Transactional
	public void guardar(IngresoArticulo ingresoArticulo) {
		ingresoArticuloDao.guardar(ingresoArticulo);
	}
	@Transactional
	public void actualizar(IngresoArticulo ingresoArticulo) {
		ingresoArticuloDao.actualizar(ingresoArticulo);
	}
	@Transactional
	public void borrar(IngresoArticulo ingresoArticulo) {
		ingresoArticuloDao.borrar(ingresoArticulo);
	}
	@Transactional
	public IngresoArticulo buscarPorId(int id) {
		return ingresoArticuloDao.buscarPorId(id);
	}


	@Transactional
	public List<IngresoArticulo> lista(){
		return ingresoArticuloDao.lista();
	}
}
