package municipalidad.pto.service;

import java.util.List;

import javax.faces.model.SelectItem;

import municipalidad.pto.model.User;

public interface UserService {
	void persistUser(User user);
	User findUserById(int id);
	void updateUser(User user);
	void deleteUser(User user);
	List<User> listaUsuarios();
	List<SelectItem> comboUser();
	User login(User user);
	boolean sesionUser(String user,String pass,Integer nivel);
	String getMD5(String input);
}
