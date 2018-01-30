package municipalidad.pto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import municipalidad.pto.dao.ArticuloDao;
import municipalidad.pto.dao.DevolucionDao;
import municipalidad.pto.dao.GenericDao;
import municipalidad.pto.dao.RelIngresoArticuloDao;
import municipalidad.pto.dao.RelSalidaArticuloDao;
import municipalidad.pto.model.Articulos;
import municipalidad.pto.service.ArticulosService;

@Service("articulosService")
public class ArticulosServiceImpl implements ArticulosService {

	@Autowired
	GenericDao genericDao;
	@Autowired
	ArticuloDao articuloDao;
	@Autowired
	RelSalidaArticuloDao relSalidaArticuloDao;
	@Autowired
	RelIngresoArticuloDao relIngresoArticuloDao;
	@Autowired
	DevolucionDao devolucionDao;

	@Transactional
	public void persistArticulos(Articulos articulo) {
		genericDao.Guardar(articulo);

	}

	@Transactional
	public Articulos findArticuloById(int id) {

		return articuloDao.findArticuloById(id);
	}

	@Transactional
	public void updateArticulos(Articulos articulo) {
		genericDao.update(articulo);

	}

	@Transactional
	public void deleteArticulos(Articulos articulo) {
		genericDao.delete(articulo);

	}

	@Transactional
	public List<Articulos> listaArticulos() {
		return articuloDao.listaArticulos();
	}
	@Transactional
	public List<String> nombreaArticuloBynombre(String articulo){
		return articuloDao.nombreaArticuloBynombre(articulo);
	}
	@Transactional
	public Long stock(int id,boolean inventariable){
		Long cantidadIngreso=0L;
		Long cantidadSalida=0L;
		Long devoluciones=0L;
		Long perdidas=0L;
		if(relIngresoArticuloDao.cantidadIngresoArticulo(id,inventariable)!=null ){
			cantidadIngreso = relIngresoArticuloDao.cantidadIngresoArticulo(id,inventariable);
			
		}
		if( relSalidaArticuloDao.salidaArticulo(id)!=null){
			cantidadSalida = relSalidaArticuloDao.salidaArticulo(id);
		}
		if(devolucionDao.salidaDevolucion(id,false)!=null){
			devoluciones=devolucionDao.salidaDevolucion(id,false);
		}
		if(devolucionDao.salidaDevolucion(id,true)!=null){
			perdidas=devolucionDao.salidaDevolucion(id,true);
		}
		if (inventariable) {
			 if(perdidas!=0L){
				 return ((cantidadIngreso+ devoluciones )- perdidas);
			 }else{
				 return ((cantidadIngreso-( cantidadSalida-devoluciones))  - perdidas); 
			 }
			
		} else {
			return (cantidadSalida - (devoluciones+ perdidas));
		}
		
	
	}
	@Transactional
	public Articulos findArticuloByCodigo(String cod){
		return articuloDao.findArticuloByCodigo(cod);
	}
}
