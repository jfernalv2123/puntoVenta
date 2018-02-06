package punto.venta.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import punto.venta.dao.UsuarioDao;
import punto.venta.model.Usuario;

@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void guardar(Usuario usuario){
		sessionFactory.getCurrentSession().persist(usuario);
	}
	public void actualizar(Usuario usuario) {
		sessionFactory.getCurrentSession().update(usuario);
	}

	public Usuario buscarPorId(int id) {
		return (Usuario) sessionFactory.getCurrentSession().get(Usuario.class, id);
	}

	public void borrar(Usuario usuario) {
		sessionFactory.getCurrentSession().delete(usuario);
	}

	public List<Usuario> lista(){
		String query = "FROM Usuario as u";
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}
	public Usuario usuarioPorRut(String rut){
		String query = "FROM Usuario as u where u.rut=:rut";
		return (Usuario)sessionFactory.getCurrentSession().createQuery(query).setString("rut", rut).uniqueResult();
	}
}
