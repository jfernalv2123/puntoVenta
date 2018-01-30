package municipalidad.pto.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import municipalidad.pto.dao.UnidadMedidaDao;
import municipalidad.pto.model.AreaArticulo;
import municipalidad.pto.model.UnidadMedida;

@Repository("unidadMediadaDao")
public class UnidadMedidaDaoImpl implements UnidadMedidaDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public UnidadMedida findUnidadMedidaById(int id) {
		return (UnidadMedida) sessionFactory.getCurrentSession().get(UnidadMedida.class, id);
	}

	public List<UnidadMedida> listaUnidadMedidas() {

		String query="FROM UnidadMedida as a";
		List<UnidadMedida> aux= sessionFactory.getCurrentSession().createQuery(query).list();

		return aux;
	}
	
	public List<SelectItem> comboUnidadMedida(){
		List<SelectItem> aux=new ArrayList<SelectItem>();
		
		String query="SELECT a.idUnidadMedida,a.unidadMedida FROM UnidadMedida as a";
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
