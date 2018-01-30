package municipalidad.pto.dao.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.management.StringValueExp;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import municipalidad.pto.dao.UserDao;
import municipalidad.pto.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void persistUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
	}

	public User findUserById(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		
	}

	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
		
	}

	public List<User> listaUsuarios() {

		String query="FROM User as u";
		List<User> aux= sessionFactory.getCurrentSession().createQuery(query).list();

		return aux;
	}
	
	public List<SelectItem> comboUser(){
		List<SelectItem> aux=new ArrayList<SelectItem>();
		
		String query="SELECT u.name,u.surname FROM User as u";
		Iterator iter = sessionFactory.getCurrentSession().createQuery(query).iterate();
		while (iter.hasNext()) {
			SelectItem item=new SelectItem();
			Object[] combo = (Object[]) iter.next();
			item.setLabel(String.valueOf(combo[0]));
			item.setValue(String.valueOf(combo[0])+" "+String.valueOf(combo[1]));
			
			aux.add(item);
		}
		return aux;
	}
	public User login(User user){

		String query="FROM User as u where u.name=:user and u.pass=:pass";
		List<User> aux= sessionFactory.getCurrentSession().createQuery(query).setString("user", user.getName()).setString("pass", user.getPass()).list();
		return aux.get(0);
	
	}

	public boolean sesionUser(String user, String pass, Integer nivel) {
		String query = "FROM User as u where u.pass=:pass and u.name=:user and u.nivel=:nivel";
		List<User> aux = sessionFactory.getCurrentSession().createQuery(query).setInteger("nivel", nivel)
				.setString("user", user).setString("pass", pass).list();
		boolean ver = false;
		try {
			if (aux.get(0) != null) {
				ver = true;
			}
		} catch (Exception e) {
			// TODO: handle exception

		}
		return ver;

	}
	
	public String getMD5(String input) {
		 try {
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 byte[] messageDigest = md.digest(input.getBytes());
		 BigInteger number = new BigInteger(1, messageDigest);
		 String hashtext = number.toString(16);

		 while (hashtext.length() < 32) {
		 hashtext = "0" + hashtext;
		 }
		 return hashtext;
		 }
		 catch (NoSuchAlgorithmException e) {
		 throw new RuntimeException(e);
		 }
		 }
}
