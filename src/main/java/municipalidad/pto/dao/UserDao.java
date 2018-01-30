package municipalidad.pto.dao;

import java.util.List;

import javax.faces.model.SelectItem;

import municipalidad.pto.model.User;

public interface UserDao {
	
	User findUserById(int id);
	List<User> listaUsuarios();
	List<SelectItem> comboUser();
	User login(User user);
	boolean sesionUser(String user,String pass,Integer nivel);
	String getMD5(String input);
}
