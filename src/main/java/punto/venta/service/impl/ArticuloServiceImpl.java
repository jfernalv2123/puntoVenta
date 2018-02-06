package punto.venta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import punto.venta.dao.ArticuloDao;
import punto.venta.model.Articulo;
import punto.venta.service.ArticuloService;

@Service("articuloService")
public class ArticuloServiceImpl implements ArticuloService {

	@Autowired
	ArticuloDao articuloDao;

	@Transactional
	public void guardar(Articulo articulo) {
		articuloDao.guardar(articulo);
	}
	@Transactional
	public void actualizar(Articulo articulo) {
		articuloDao.actualizar(articulo);
	}
	@Transactional
	public void borrar(Articulo articulo) {
		articuloDao.borrar(articulo);
	}
	@Transactional
	public Articulo buscarPorId(int id) {
		return articuloDao.buscarPorId(id);
	}
	@Transactional
	public Articulo buscarPorCodigo(String cod) {
		return articuloDao.buscarPorCodigo(cod);
	}
	@Transactional
	public List<Articulo> lista(){
		return articuloDao.lista();
	}

}
