package punto.venta.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import punto.venta.dao.ArticuloDao;
import punto.venta.model.Articulo;

@Repository("articuloDao")
public class ArticuloDaoImpl implements ArticuloDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void guardar(Articulo articulo) {
		sessionFactory.getCurrentSession().persist(articulo);
	}

	public void actualizar(Articulo articulo) {
		sessionFactory.getCurrentSession().update(articulo);
	}

	public Articulo buscarPorId(int id) {
		return (Articulo) sessionFactory.getCurrentSession().get(Articulo.class, id);
	}

	public void borrar(Articulo articulo) {
		sessionFactory.getCurrentSession().delete(articulo);
	}

	public List<Articulo> lista() {
		String query = "FROM Articulo as a";
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}
	public Articulo buscarPorCodigo(String cod){
		String query = "FROM Articulo as a where a.codigo='"+cod+"'";
		return (Articulo)sessionFactory.getCurrentSession().createQuery(query).list().get(0);
	}
}
