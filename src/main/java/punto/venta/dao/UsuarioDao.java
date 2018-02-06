package punto.venta.dao;

import java.util.List;

import punto.venta.model.Usuario;

public interface UsuarioDao {
	void guardar(Usuario usuario);
	void actualizar(Usuario usuario);
	Usuario buscarPorId(int id);
	void borrar(Usuario usuario);
	List<Usuario> lista();
	Usuario usuarioPorRut(String rut);
}
