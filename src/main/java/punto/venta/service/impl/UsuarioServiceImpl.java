package punto.venta.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.management.StringValueExp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import punto.venta.constantes.Constantes;
import punto.venta.constantes.Nivel;
import punto.venta.dao.UsuarioDao;
import punto.venta.model.Usuario;
import punto.venta.service.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioDao usuarioDao;
	
	@Transactional
	public void guardar(Usuario usuario) {
		usuarioDao.guardar(usuario);
	}
	@Transactional
	public void actualizar(Usuario usuario) {
		usuarioDao.actualizar(usuario);
	}
	@Transactional
	public void borrar(Usuario usuario) {
		usuarioDao.borrar(usuario);
	}
	@Transactional
	public Usuario buscarPorId(int id) {
		return usuarioDao.buscarPorId(id);
	}
	@Transactional
	public List<Usuario> lista(){
		return usuarioDao.lista();
	}
	@Transactional
	public List<SelectItem> combo() {
		List<SelectItem> aux = new ArrayList<SelectItem>();
		for(Usuario t:usuarioDao.lista()){
			SelectItem item = new SelectItem();
			item.setLabel(t.getRut());
			item.setValue(t.getId());
			aux.add(item);
		}
		return aux;
	}
	@Transactional
	public List<SelectItem> comboNiveles() {
		List<SelectItem> aux = new ArrayList<SelectItem>();
		List<Nivel> nivel=new ArrayList<Nivel>();
	Nivel seleccione= new Nivel(0,Constantes.SELECCIONE );	
	Nivel admin =new Nivel(1, Constantes.ADMINISTRADOR);
	Nivel vende = new Nivel(2, Constantes.VENDEDOR);
	Nivel visita = new Nivel(2, Constantes.VISITA);
	nivel.add(vende);
	nivel.add(visita);
	nivel.add(admin);
	nivel.add(seleccione);
		for(Nivel n:nivel){
			SelectItem item = new SelectItem();;	
			item.setLabel(n.getCargo());
			item.setValue(n.getNivel());
			aux.add(item);
		}
		
		return aux;
	}
	@Transactional
	public String encripta(String txt, String hashType) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
	@Transactional
	public boolean compruebaPass(String rut, String pass){
		boolean salida=false;
		
		try {
			Usuario user=usuarioDao.usuarioPorRut(rut);
			if(user.getPass().equals(encripta(pass,Constantes.MD5))){
				salida=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
			
		
	
		return salida;
	}
	@Transactional
	public Usuario usuarioPorRut(String rut){
		return usuarioDao.usuarioPorRut(rut);
	}
}
