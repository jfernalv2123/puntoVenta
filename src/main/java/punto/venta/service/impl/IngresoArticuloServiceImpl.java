package punto.venta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import punto.venta.dao.IngresoArticuloDao;
import punto.venta.dao.VentaArticuloDao;
import punto.venta.model.Articulo;
import punto.venta.model.IngresoArticulo;
import punto.venta.model.VentaArticulo;
import punto.venta.service.IngresoArticuloService;
@Service("ingresoArticuloService")
public class IngresoArticuloServiceImpl implements IngresoArticuloService {

	@Autowired
	IngresoArticuloDao ingresoArticuloDao;
	@Autowired
	VentaArticuloDao ventaArticuloDao;
	
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
	@Transactional
	public List<IngresoArticulo> listaIngresosPorArticulo(Integer idArticulo){
		return ingresoArticuloDao.listaIngresosPorArticulo(idArticulo);
	}
	@Transactional
	public IngresoArticulo ultimoIngresoPorArticulo(Articulo art){
		return ingresoArticuloDao.ultimoIngresoPorArticulo(art);
	}
	@Transactional
	public Integer stock(Articulo art){
		Integer ingresos=0;
		Integer ventas=0;
		for(IngresoArticulo ing:ingresoArticuloDao.listaIngresosPorArticulo(art.getId())){
			ingresos+=ing.getCantidad();
		}
		for(VentaArticulo vent:ventaArticuloDao.listaPorArticulo(art)){
			ventas+=vent.getCantidad();
		}
		return (ingresos-ventas);
	}
}
