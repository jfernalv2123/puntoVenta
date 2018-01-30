package punto.venta.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import punto.venta.dao.VentaDao;
import punto.venta.model.Venta;

public class VentaDaoImpl implements VentaDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void guardar(Venta venta){
		sessionFactory.getCurrentSession().persist(venta);
	}
	public void actualizar(Venta venta) {
		sessionFactory.getCurrentSession().update(venta);
	}

	public Venta buscarPorId(int id) {
		return (Venta) sessionFactory.getCurrentSession().get(Venta.class, id);
	}

	public void borrar(Venta venta) {
		sessionFactory.getCurrentSession().delete(venta);
	}

	public List<Venta> lista(){
		String query = "FROM Venta as v";
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}
}
