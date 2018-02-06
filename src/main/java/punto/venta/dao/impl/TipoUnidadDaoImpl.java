package punto.venta.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import punto.venta.dao.TipoUnidadDao;
import punto.venta.model.TipoUnidad;

@Repository("tipoUnidadDao")
public class TipoUnidadDaoImpl implements TipoUnidadDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void guardar(TipoUnidad tipoUnidad){
		sessionFactory.getCurrentSession().persist(tipoUnidad);
	}
	public void actualizar(TipoUnidad tipoUnidad) {
		sessionFactory.getCurrentSession().update(tipoUnidad);
	}

	public TipoUnidad buscarPorId(int id) {
		return (TipoUnidad) sessionFactory.getCurrentSession().get(TipoUnidad.class, id);
	}

	public void borrar(TipoUnidad tipoUnidad) {
		sessionFactory.getCurrentSession().delete(tipoUnidad);
	}

	public List<TipoUnidad> lista(){
		String query = "FROM TipoUnidad as t";
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}
}
