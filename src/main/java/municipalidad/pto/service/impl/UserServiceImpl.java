package municipalidad.pto.service.impl;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import municipalidad.pto.dao.GenericDao;
import municipalidad.pto.dao.UserDao;
import municipalidad.pto.model.User;
import municipalidad.pto.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	@Autowired
	GenericDao genericDao;
	
	@Transactional
	public void persistUser(User user) {
		genericDao.Guardar(user);
		
	}
	@Transactional
	public User findUserById(int id) {
	
		return userDao.findUserById(id);
	}
	@Transactional
	public void updateUser(User user) {
		genericDao.update(user);
		
	}
	@Transactional
	public void deleteUser(User user) {
		genericDao.delete(user);
		
	}
	@Transactional
	public List<User> listaUsuarios() {
		return userDao.listaUsuarios();
	}
	@Transactional
	public List<SelectItem> comboUser(){
		return userDao.comboUser();
	}

	@Transactional
	public User login(User user){
		return userDao.login(user);
	}
	@Transactional
	public boolean sesionUser(String user,String pass,Integer nivel){
		return userDao.sesionUser(user, pass, nivel);
	}
	@Transactional
	public String getMD5(String input){
		return userDao.getMD5(input);
	}
}
