package punto.venta.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import punto.venta.dao.IngresoArticuloDao;
import punto.venta.model.Articulo;
import punto.venta.model.IngresoArticulo;

@Repository("ingresoArticuloDao")
public class IngresoArticuloDaoImpl implements IngresoArticuloDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void guardar(IngresoArticulo ingresoArticulo){
		sessionFactory.getCurrentSession().persist(ingresoArticulo);
	}
	public void actualizar(IngresoArticulo ingresoArticulo) {
		sessionFactory.getCurrentSession().update(ingresoArticulo);
	}

	public IngresoArticulo buscarPorId(int id) {
		return (IngresoArticulo) sessionFactory.getCurrentSession().get(IngresoArticulo.class, id);
	}

	public void borrar(IngresoArticulo ingresoArticulo) {
		sessionFactory.getCurrentSession().delete(ingresoArticulo);
	}

	public List<IngresoArticulo> lista() {
		String query = "FROM IngresoArticulo as i";
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}
	public List<IngresoArticulo> listaIngresosPorArticulo(Integer idArticulo){
		String query = "FROM IngresoArticulo as i where i.articulo.id="+idArticulo;
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}
	public IngresoArticulo ultimoIngresoPorArticulo(Articulo art){
		String query = "FROM IngresoArticulo as i where i.articulo.id="+art.getId()+" order by i.fecha desc";
		return (IngresoArticulo)sessionFactory.getCurrentSession().createQuery(query).list().get(0);
	}

}
