package com.ironman.DAO;

import com.ironman.defaultBean.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 16:51 2017/11/7 0007
 **/
public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet resultSet, int rows) throws SQLException{
		User user = new User();
		user.setUsername(resultSet.getString(1));
		user.setPsw(resultSet.getString(2));
		user.setAddr(resultSet.getString(3));
		user.setAge(resultSet.getInt(4));
		user.setCreateDate(new Date(resultSet.getTimestamp(5).getTime()));
//		System.out.println(resultSet.getTimestamp(5));
//		System.out.println(new Date(resultSet.getTimestamp(5).getTime()));
		System.out.println(user);
		return user;
	}

}
