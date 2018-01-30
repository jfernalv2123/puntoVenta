package municipalidad.pto.service.impl;

import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import municipalidad.pto.dao.GenericDao;
import municipalidad.pto.dao.TipoDao;
import municipalidad.pto.model.Tipo;
import municipalidad.pto.service.TipoService;

@Service("tipoService")
public class TipoServiceImpl implements TipoService{

	@Autowired
	GenericDao genericDao;
	
	@Autowired
	TipoDao tipoDao;
	
	@Transactional
	public void persistTipo(Tipo tipo) {
		genericDao.Guardar(tipo);
		
	}
	@Transactional
	public Tipo findTipoById(int id) {
	
		return tipoDao.findTipoById(id);
	}
	@Transactional
	public void updateTipo(Tipo tipo) {
		genericDao.update(tipo);
		
	}
	@Transactional
	public void deleteTipo(Tipo tipo) {
		genericDao.delete(tipo);
		
	}
	@Transactional
	public List<Tipo> listaTipos() {
		return tipoDao.listaTipos();
	}
	@Transactional
	public List<SelectItem> comboTipo(){
		return tipoDao.comboTipo();
	}
}
