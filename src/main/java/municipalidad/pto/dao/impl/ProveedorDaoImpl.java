package municipalidad.pto.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import municipalidad.pto.dao.ProveedorDao;
import municipalidad.pto.model.AreaArticulo;
import municipalidad.pto.model.Proveedor;

@Repository("proveedorDao")
public class ProveedorDaoImpl implements ProveedorDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Proveedor findProveedorById(int id) {
		return (Proveedor) sessionFactory.getCurrentSession().get(Proveedor.class, id);
	}

	public List<Proveedor> listaProveedor() {

		String query="FROM Proveedor";
		List<Proveedor> aux= sessionFactory.getCurrentSession().createQuery(query).list();

		return aux;
	}
	
	public List<SelectItem> comboProveedor(){
		List<SelectItem> aux=new ArrayList<SelectItem>();
		
		String query="SELECT a.idProveedor,a.proveedor FROM Proveedor as a";
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
	public Proveedor proveedorBynombre(String proveedor){
		String query="FROM Proveedor as p where p.proveedor='"+proveedor+"'";
		List<Proveedor>  aux= sessionFactory.getCurrentSession().createQuery(query).list();
		Proveedor proAux=new Proveedor();
		for(Proveedor p:aux){
			proAux=p;
		}
		return proAux;
	}
	public List<String> nombreProveedorByName(String proveedor){
		String query="Select p.proveedor FROM Proveedor as p where p.proveedor like '"+proveedor+"%'";
		List<String> aux= sessionFactory.getCurrentSession().createQuery(query).list();
		return aux;
	}

	public List<Proveedor> buscadorTablaProveedores(Integer id, String proveedor, boolean credito, String articulo,
			Integer categoria, String fono, String mail, String direccion, String ciudad, String region) {
		String query = "";
		if (id != null) {
			query = "FROM Proveedor as p where p.idProveedor="+id;

		}else{
			query="FROM Proveedor";
		}
		List<Proveedor> aux = sessionFactory.getCurrentSession().createQuery(query).list();
		return null;
	}
}
