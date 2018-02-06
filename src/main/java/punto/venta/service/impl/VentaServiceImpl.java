package punto.venta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import punto.venta.dao.VentaDao;
import punto.venta.model.Venta;
import punto.venta.service.VentaService;

@Service("ventaService")
public class VentaServiceImpl implements VentaService{

	@Autowired
	VentaDao ventaDao;
	
	@Transactional
	public void guardar(Venta venta) {
		ventaDao.guardar(venta);
	}
	@Transactional
	public void actualizar(Venta venta) {
		ventaDao.actualizar(venta);
	}
	@Transactional
	public void borrar(Venta venta) {
		ventaDao.borrar(venta);
	}
	@Transactional
	public Venta buscarPorId(int id) {
		return ventaDao.buscarPorId(id);
	}
	@Transactional
	public List<Venta> lista(){
		return ventaDao.lista();
	}
	@Transactional
	public Venta ultimaVenta(){
		return ventaDao.buscarPorId(ventaDao.ultimaVenta());
	}
}
