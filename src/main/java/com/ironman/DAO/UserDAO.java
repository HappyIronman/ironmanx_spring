package com.ironman.DAO;

import com.ironman.defaultBean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 15:58 2017/11/7 0007
 **/
@Repository
public class UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addUser(User user){

		String sql = "insert into user2 (username, psw, createDate,age) values (?, ?, ?,?)";

		jdbcTemplate.update(sql, user.getUsername(), user.getPsw(), user.getCreateDate(),user.getAge());

	}

	public List<User> selectUsers(Date start, Date end){

		String sql = "select username,psw,addr,age,createDate from user where createDate between ? and ?";
		Object[] objects = {start, end};
		return jdbcTemplate.query(sql, objects, new UserMapper());
	}
}
