package punto.venta.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import punto.venta.dao.TipoArticuloDao;
import punto.venta.model.TipoArticulo;

@Repository("tipoArticuloDao")
public class TipoArticuloDaoImpl implements TipoArticuloDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void guardar(TipoArticulo tipoArticulo){
		sessionFactory.getCurrentSession().persist(tipoArticulo);
	}
	public void actualizar(TipoArticulo tipoArticulo) {
		sessionFactory.getCurrentSession().update(tipoArticulo);
	}

	public TipoArticulo buscarPorId(int id) {
		return (TipoArticulo) sessionFactory.getCurrentSession().get(TipoArticulo.class, id);
	}

	public void borrar(TipoArticulo tipoArticulo) {
		sessionFactory.getCurrentSession().delete(tipoArticulo);
	}

	public List<TipoArticulo> lista(){
		String query = "FROM TipoArticulo as t";
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}
}
