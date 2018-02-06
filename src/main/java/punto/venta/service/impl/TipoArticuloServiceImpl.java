package punto.venta.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import punto.venta.constantes.Constantes;
import punto.venta.dao.TipoArticuloDao;
import punto.venta.model.TipoArticulo;
import punto.venta.service.TipoArticuloService;

@Service("tipoArticuloService")
public class TipoArticuloServiceImpl implements TipoArticuloService{

	@Autowired
	TipoArticuloDao tipoArticuloDao;
	
	@Transactional
	public void guardar(TipoArticulo tipoArticulo) {
		tipoArticuloDao.guardar(tipoArticulo);
	}
	@Transactional
	public void actualizar(TipoArticulo tipoArticulo) {
		tipoArticuloDao.actualizar(tipoArticulo);
	}
	@Transactional
	public void borrar(TipoArticulo tipoArticulo) {
		tipoArticuloDao.borrar(tipoArticulo);
	}
	@Transactional
	public TipoArticulo buscarPorId(int id) {
		return tipoArticuloDao.buscarPorId(id);
	}
	@Transactional
	public List<TipoArticulo> lista(){
		return tipoArticuloDao.lista();
	}
	@Transactional
	public List<SelectItem> combo() {
		List<SelectItem> aux = new ArrayList<SelectItem>();
		SelectItem selec = new SelectItem();
		selec.setLabel(Constantes.SELECCIONE);
		selec.setValue(Constantes.CEROSTRING);
		aux.add(selec);
		for(TipoArticulo t:tipoArticuloDao.lista()){
			SelectItem item = new SelectItem();
			item.setLabel(t.getTipo());
			item.setValue(t.getId());
			aux.add(item);
		}
		return aux;
	}
}
