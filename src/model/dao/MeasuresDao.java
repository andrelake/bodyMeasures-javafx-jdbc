package model.dao;

import java.util.List;

import model.entities.Measures;
import model.entities.User;

public interface MeasuresDao {

	void insert(Measures obj);
	
	void update(Measures obj);
	
	void deleteById(Integer id);
	
	Measures findById(Integer id);
	
	List<Measures> findAll();
	
	List<Measures> findByDepartment(User user);
}
