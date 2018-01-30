package punto.venta.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import punto.venta.dao.VentaArticuloDao;
import punto.venta.model.VentaArticulo;

public class VentaArticuloDaoImpl implements VentaArticuloDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void guardar(VentaArticulo ventaArticulo){
		sessionFactory.getCurrentSession().persist(ventaArticulo);
	}
	public void actualizar(VentaArticulo ventaArticulo) {
		sessionFactory.getCurrentSession().update(ventaArticulo);
	}

	public VentaArticulo buscarPorId(int id) {
		return (VentaArticulo) sessionFactory.getCurrentSession().get(VentaArticulo.class, id);
	}

	public void borrar(VentaArticulo ventaArticulo) {
		sessionFactory.getCurrentSession().delete(ventaArticulo);
	}

	public List<VentaArticulo> lista(){
		String query = "FROM VentaArticulo as va";
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}
}
