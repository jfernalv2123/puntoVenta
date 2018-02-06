package punto.venta.service;

import java.util.List;

import javax.faces.model.SelectItem;

import punto.venta.model.Usuario;

public interface UsuarioService {
	void guardar(Usuario usuario);
	void actualizar(Usuario usuario);
	void borrar(Usuario usuario);
	Usuario buscarPorId(int id);
	List<Usuario> lista();
	List<SelectItem> combo();
	List<SelectItem> comboNiveles();
	String encripta(String txt, String hashType);
	boolean compruebaPass(String rut, String pass);
	Usuario usuarioPorRut(String rut);
}
