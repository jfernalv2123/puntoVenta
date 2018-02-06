package punto.venta.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import punto.venta.dao.UsuarioDao;
import punto.venta.dao.VentaArticuloDao;
import punto.venta.model.Articulo;
import punto.venta.model.Usuario;
import punto.venta.model.Venta;
import punto.venta.model.VentaArticulo;
import punto.venta.service.VentaArticuloService;

@Service("ventaArticuloService")
public class VentaArticuloServiceImpl implements VentaArticuloService{
	@Autowired
	VentaArticuloDao ventaArticuloDao;
	
	@Transactional
	public void guardar(VentaArticulo ventaArticulo) {
		ventaArticuloDao.guardar(ventaArticulo);
	}
	@Transactional
	public void actualizar(VentaArticulo ventaArticulo) {
		ventaArticuloDao.actualizar(ventaArticulo);
	}
	@Transactional
	public void borrar(VentaArticulo ventaArticulo) {
		ventaArticuloDao.borrar(ventaArticulo);
	}
	@Transactional
	public VentaArticulo buscarPorId(int id) {
		return ventaArticuloDao.buscarPorId(id);
	}
	@Transactional
	public List<VentaArticulo> lista(){
		return ventaArticuloDao.lista();
	}
	@Transactional
	public List<VentaArticulo> listaPorVenta(Venta venta){
		return ventaArticuloDao.listaPorVenta(venta);
	}
	@Transactional
	public List<VentaArticulo> listaPorArticulo(Articulo art ){
		return ventaArticuloDao.listaPorArticulo(art);
	}
	@Transactional
	public List<VentaArticulo> listaPorFechas(Date desde,Date hasta ){
		return ventaArticuloDao.listaPorFechas(desde, hasta);
	}
}
