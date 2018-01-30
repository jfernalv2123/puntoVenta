package municipalidad.pto.service.impl;

import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import municipalidad.pto.dao.AreaDao;
import municipalidad.pto.dao.EstadoDao;
import municipalidad.pto.dao.GenericDao;
import municipalidad.pto.model.AreaArticulo;
import municipalidad.pto.model.Estado;
import municipalidad.pto.service.EstadoService;
@Service("estadoService")
public class EstadoServiceImpl implements EstadoService{
	
	@Autowired
	EstadoDao estadoDao;
	@Autowired
	GenericDao genericDao;
	
	
	@Transactional
	public void persistEstado(Estado area) {
		genericDao.Guardar(area);
		
	}
	@Transactional
	public Estado findEstadoById(int id) {
	
		return estadoDao.findEstadoById(id);
	}
	@Transactional
	public void updateEstado(Estado area) {
		genericDao.update(area);
		
	}
	@Transactional
	public void deleteEstado(Estado area) {
		genericDao.delete(area);
		
	}
	@Transactional
	public List<Estado> listaEstados() {
		return estadoDao.listaEstados();
	}
	@Transactional
	public List<SelectItem> comboEstado(){
		return estadoDao.comboEstado();
	}

}
