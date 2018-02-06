package punto.venta.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import punto.venta.dao.VentaDao;
import punto.venta.model.Venta;

@Repository("ventaDao")
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
	public Integer ultimaVenta(){
		String query="select max(v.id) FROM Venta as v";
		List<Integer> aux= sessionFactory.getCurrentSession().createQuery(query).list();

		return aux.get(0);
	}
}
