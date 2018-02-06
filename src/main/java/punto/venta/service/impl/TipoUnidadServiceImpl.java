package punto.venta.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import punto.venta.constantes.Constantes;
import punto.venta.dao.TipoUnidadDao;
import punto.venta.model.TipoUnidad;
import punto.venta.service.TipoUnidadService;

@Service("tipoUnidadService")
public class TipoUnidadServiceImpl implements TipoUnidadService{
	@Autowired
	TipoUnidadDao tipoUnidadDao;
	
	@Transactional
	public void guardar(TipoUnidad tipoArticulo) {
		tipoUnidadDao.guardar(tipoArticulo);
	}
	@Transactional
	public void actualizar(TipoUnidad tipoArticulo) {
		tipoUnidadDao.actualizar(tipoArticulo);
	}
	@Transactional
	public void borrar(TipoUnidad tipoArticulo) {
		tipoUnidadDao.borrar(tipoArticulo);
	}
	@Transactional
	public TipoUnidad buscarPorId(int id) {
		return tipoUnidadDao.buscarPorId(id);
	}
	@Transactional
	public List<TipoUnidad> lista(){
		return tipoUnidadDao.lista();
	}
	@Transactional
	public List<SelectItem> combo() {
		List<SelectItem> aux = new ArrayList<SelectItem>();
		SelectItem selec = new SelectItem();
		selec.setLabel(Constantes.SELECCIONE);
		selec.setValue(Constantes.CEROSTRING);
		aux.add(selec);
		for(TipoUnidad t:tipoUnidadDao.lista()){
			SelectItem item = new SelectItem();
			item.setLabel(t.getTipo());
			item.setValue(t.getId());
			aux.add(item);
		}
		return aux;
	}
}
