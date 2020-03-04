package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Statement;

import db.DB;
import db.DbException;
import model.dao.MeasuresDao;
import model.entities.Measures;
import model.entities.User;

public class MeasuresDaoJDBC implements MeasuresDao{

	private Connection conn;
	
	public MeasuresDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Measures obj) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"INSERT INTO bodyinfo "
					+ "(DateReg, Weight, BodyFat, Biceps_right, Biceps_left, Shoulders, Chest, Waist, Thigh_right,"
					+ " Thigh_left, Calf_right, Calf_left, UserId) VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getDateReg());
			st.setDouble(2, obj.getWeight());
			st.setDouble(3, obj.getBodyFat());
			st.setDouble(4, obj.getBicepsRight());
			st.setDouble(5, obj.getBicepsLeft());
			st.setDouble(6, obj.getShoulders());
			st.setDouble(7, obj.getChest());
			st.setDouble(8, obj.getWaist());
			st.setDouble(9, obj.getThighRight());
			st.setDouble(10, obj.getThighLeft());
			st.setDouble(11, obj.getCalfRight());
			st.setDouble(12, obj.getCalfLeft());
			st.setDouble(13, obj.getUser().getId());
			
			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setInfoId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Error: No row affected");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Measures obj) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"UPDATE bodyinfo "
					+ "SET DateReg = ?, Weight = ?, BodyFat = ?, Biceps_right = ?, Biceps_left = ?, Shoulders = ?,"
					+ " Chest = ?, Waist = ?, Thigh_right = ?, Thigh_left = ?, Calf_right = ?, Calf_left = ?, UserId = ? "
					+ "WHERE InfoId = ?");
			
			st.setString(1, obj.getDateReg());
			st.setDouble(2, obj.getWeight());
			st.setDouble(3, obj.getBodyFat());
			st.setDouble(4, obj.getBicepsRight());
			st.setDouble(5, obj.getBicepsLeft());
			st.setDouble(6, obj.getShoulders());
			st.setDouble(7, obj.getChest());
			st.setDouble(8, obj.getWaist());
			st.setDouble(9, obj.getThighRight());
			st.setDouble(10, obj.getThighLeft());
			st.setDouble(11, obj.getCalfRight());
			st.setDouble(12, obj.getCalfLeft());
			st.setDouble(13, obj.getUser().getId());
			st.setInt(14, obj.getInfoId());
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"DELETE FROM bodyinfo WHERE InfoId = ?");
			
			st.setInt(1, id);
			
			int rowsAffected = st.executeUpdate();
			if(rowsAffected == 0) {
				throw new DbException("Cannot find this id");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Measures findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT bodyinfo.*,users.Name as UserName, users.Age as UserAge, users.Gender as UserGender "
					+ "FROM bodyinfo INNER JOIN users "
					+ "ON bodyinfo.UserId = users.Id "
					+ "WHERE bodyinfo.InfoId = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				User user = instantiateUser(rs);
				Measures obj = instantiateMeasures(rs, user);
				return obj;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Measures instantiateMeasures(ResultSet rs, User user) throws SQLException{
		
		Measures obj = new Measures();
		obj.setInfoId(rs.getInt("InfoId"));
		obj.setDateReg(rs.getString("DateReg"));
		obj.setWeight(rs.getDouble("Weight"));
		obj.setBodyFat(rs.getDouble("BodyFat"));
		obj.setBicepsRight(rs.getDouble("Biceps_right"));
		obj.setBicepsLeft(rs.getDouble("Biceps_left"));
		obj.setShoulders(rs.getDouble("Shoulders"));
		obj.setChest(rs.getDouble("Chest"));
		obj.setWaist(rs.getDouble("Waist"));
		obj.setThighRight(rs.getDouble("Thigh_right"));
		obj.setThighLeft(rs.getDouble("Thigh_left"));
		obj.setCalfRight(rs.getDouble("Calf_right"));
		obj.setCalfLeft(rs.getDouble("Calf_left"));
		obj.setUser(user);
		return obj;
	}

	private User instantiateUser(ResultSet rs) throws SQLException{
		
		User user = new User();
		user.setId(rs.getInt("UserId"));
		user.setName(rs.getString("UserName"));
		user.setAge(rs.getInt("UserAge"));
		user.setGender(rs.getString("UserGender"));
		return user;
	}

	@Override
	public List<Measures> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT bodyinfo.*,users.Name as UserName, users.Age as UserAge, users.Gender as UserGender "
					+ "FROM bodyinfo INNER JOIN users "
					+ "ON bodyinfo.UserId = users.Id "
					+ "ORDER BY InfoId");
			
			rs = st.executeQuery();
			
			List<Measures> list = new ArrayList<>();
			Map<Integer, User> map = new HashMap<>();
			
			while(rs.next()) {
				User user = map.get(rs.getInt("UserId"));
				
				if(user == null) {
					user = instantiateUser(rs);
					map.put(rs.getInt("UserId"), user);
				}
				
				Measures obj = instantiateMeasures(rs, user);
				list.add(obj);
			}
			return list;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Measures> findByUser(User user) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT bodyinfo.*,users.Name as UserName, users.Age as UserAge, users.Gender as UserGender "
					+ "FROM bodyinfo INNER JOIN users "
					+ "ON bodyinfo.UserId = users.Id "
					+ "WHERE UserId = ? "
					+ "ORDER BY InfoId");
			
			st.setInt(1, user.getId());
			rs = st.executeQuery();
			
			List<Measures> list = new ArrayList<>();
			Map<Integer, User> map = new HashMap<>();
			
			while(rs.next()) {
				User user1 = map.get(rs.getInt("UserId"));
				
				if(user1 == null) {
					user1 = instantiateUser(rs);
					map.put(rs.getInt("UserId"), user1);
				}
				
				Measures obj = instantiateMeasures(rs, user1);
				list.add(obj);
			}
			return list;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
}
