package com.sw.roster.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sw.roster.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	// @Override
	public User findByID(int id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		String sql = "SELECT * FROM users WHERE users_id=:id";

		User result = namedParameterJdbcTemplate.queryForObject(sql, params, new UserMapper());

		return result;

	}

	// @Override
	public List<User> findAll() {

		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM users";

		List<User> result = namedParameterJdbcTemplate.query(sql, params, new UserMapper());

		return result;

	}

	private static final class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUserID(rs.getInt("users_id"));
			user.setUserName(rs.getString("user_name"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			return user;
		}
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", user.getUserName());
		params.put("id", user.getUserID());
		params.put("email", user.getEmail());
		params.put("password", user.getPassword());

		String sql = "INSERT INTO users (users_id, user_name, email, password) VALUES (:id, :name, :email, :password)";

		return namedParameterJdbcTemplate.update(sql, params);
	}

}
