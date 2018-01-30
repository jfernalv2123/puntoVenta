package municipalidad.pto.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import municipalidad.pto.dao.EstadoDao;
import municipalidad.pto.model.Estado;

@Repository("estadoDao")
public class EstadoDaoImpl implements EstadoDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Estado findEstadoById(int id) {
		return (Estado) sessionFactory.getCurrentSession().get(Estado.class, id);
	}
	public List<Estado> listaEstados() {

		String query="FROM Estado as a";
		List<Estado> aux= sessionFactory.getCurrentSession().createQuery(query).list();

		return aux;
	}
	
	public List<SelectItem> comboEstado(){
		List<SelectItem> aux=new ArrayList<SelectItem>();
		
		String query="SELECT a.idEstado,a.estado FROM Estado as a";
		Iterator iter = sessionFactory.getCurrentSession().createQuery(query).iterate();
		while (iter.hasNext()) {
			SelectItem item=new SelectItem();
			Object[] combo = (Object[]) iter.next();
			item.setLabel(String.valueOf(combo[1]));
			item.setValue(String.valueOf(combo[0]));
			
			aux.add(item);
		}
		return aux;
	}
}
