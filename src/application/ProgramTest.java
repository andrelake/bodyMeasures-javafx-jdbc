package application;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entities.User;

public class ProgramTest {

	public static void main(String[] args) {
		
		UserDao userDao = DaoFactory.createUserDao();
		
		User user = userDao.findById(2);
		
		System.out.println(user);
	}

}
