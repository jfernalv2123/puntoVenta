package municipalidad.pto.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import municipalidad.pto.dao.FonoDao;
import municipalidad.pto.model.Fono;
import municipalidad.pto.model.Proveedor;

@Repository("fonoDao")
public class FonoDaoImpl implements FonoDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Fono findFonoById(int id) {
		return (Fono) sessionFactory.getCurrentSession().get(Fono.class, id);
	}

	public List<Fono> listaFonos() {

		String query="FROM Fono as f";
		List<Fono> aux= sessionFactory.getCurrentSession().createQuery(query).list();

		return aux;
	}
	
	public List<SelectItem> comboFono(){
		List<SelectItem> aux=new ArrayList<SelectItem>();
		
		String query="SELECT f.idFono,f.fono FROM Fono as f";
		Iterator iter = sessionFactory.getCurrentSession().createQuery(query).iterate();
		while (iter.hasNext()) {
			SelectItem item=new SelectItem();
			Object[] combo = (Object[]) iter.next();
			item.setLabel(String.valueOf(combo[0]));
			item.setValue(String.valueOf(combo[1]));
			
			aux.add(item);
		}
		return aux;
	}
	public List<Fono> listaFonosByProveedor(Integer proveedor) {

		String query = "FROM Fono as f where f.proveedor.idProveedor=" + proveedor;
		List<Fono> aux = sessionFactory.getCurrentSession().createQuery(query).list();

		return aux;
	}
	public List<String> nombreFonoByName(String fono){
		String query="Select f.fono FROM Fono as f where f.fono like '"+fono+"%'";
		List<String> aux= sessionFactory.getCurrentSession().createQuery(query).list();
		return aux;
	}
}
