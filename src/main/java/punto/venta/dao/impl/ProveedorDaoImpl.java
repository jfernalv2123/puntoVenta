package punto.venta.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import punto.venta.dao.ProveedorDao;
import punto.venta.model.IngresoArticulo;
import punto.venta.model.Proveedor;

@Repository("proveedorDao")
public class ProveedorDaoImpl implements ProveedorDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void guardar(Proveedor proveedor){
		sessionFactory.getCurrentSession().persist(proveedor);
	}
	public void actualizar(Proveedor proveedor) {
		sessionFactory.getCurrentSession().update(proveedor);
	}

	public Proveedor buscarPorId(int id) {
		return (Proveedor) sessionFactory.getCurrentSession().get(Proveedor.class, id);
	}

	public void borrar(Proveedor proveedor) {
		sessionFactory.getCurrentSession().delete(proveedor);
	}

	public List<Proveedor> lista(){
		String query = "FROM Proveedor as p";
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}

}
