package cn.tongyouhui.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.tongyouhui.vo.User;
@Repository
public class UserDaoImpl implements UserDao{
	
	@Resource
	private JdbcTemplate template;

	@Override
	public User findByMobile(String mobile) {
		String sql = "select * from user where mobile=?";
		Object[] params = {mobile};
		RowMapper<User> mapper = new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setMobile(rs.getString("mobile"));
				user.setPassword(rs.getString("password"));
				user.setLoginTime(rs.getString("loginTime"));
				return user;
			}
		};
		/*User user = null;
		try {
			user = template.queryForObject(sql, params, mapper);  //返回结果数量=0或>1时，抛出异常
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			user = null;
		}
		return user;*/
		List<User> userList = template.query(sql,params,mapper);
		if(userList != null && userList.size() > 0){
			return userList.get(0);
		}else{
			return null;
		}
		
	}
	
	@Override
	public void save(User user) {
		String sql = "insert into user (mobile,password,loginTime)values(?,?,?)";
		Object[] params = {user.getMobile(),user.getPassword(),user.getLoginTime()};
		template.update(sql, params);
	}

}
