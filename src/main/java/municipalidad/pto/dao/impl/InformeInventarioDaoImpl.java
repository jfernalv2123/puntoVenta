package municipalidad.pto.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import municipalidad.pto.dao.InformeInventarioDao;
import municipalidad.pto.model.InformeInventario;

@Repository("informeInventarioDao")
public class InformeInventarioDaoImpl implements InformeInventarioDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public InformeInventario findInformeInventarioById(int id) {
		return (InformeInventario) sessionFactory.getCurrentSession().get(InformeInventario.class, id);
	}

	public List<InformeInventario> listaInformeInventario() {

		String query="FROM InformeInventario as a";
		List<InformeInventario> aux= sessionFactory.getCurrentSession().createQuery(query).list();

		return aux;
	}
	public Integer ultimoInforme(){
		String query="select max(i.idInforme) FROM InformeInventario as i";
		List<Integer> aux= sessionFactory.getCurrentSession().createQuery(query).list();

		return aux.get(0);
	}
}
