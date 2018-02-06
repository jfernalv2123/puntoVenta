package punto.venta.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import punto.venta.dao.VentaArticuloDao;
import punto.venta.model.Articulo;
import punto.venta.model.Venta;
import punto.venta.model.VentaArticulo;

@Repository("ventaArticuloDao")
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
	public List<VentaArticulo> listaPorVenta(Venta venta){
		String query = "FROM VentaArticulo as va where va.venta.id="+venta.getId();
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}
	public List<VentaArticulo> listaPorArticulo(Articulo art ){
		String query = "FROM VentaArticulo as va where va.articulo.id="+art.getId();
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}
	public List<VentaArticulo> listaPorFechas(Date desde,Date hasta ){
		SimpleDateFormat formatear = new SimpleDateFormat("yyyy-MM-dd");
		String query = "FROM VentaArticulo as va where va.venta.fecha BETWEEN '"+formatear.format(desde)+"' and '"+formatear.format(hasta)+"'";
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}
}
