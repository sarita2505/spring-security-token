package com.spring.dao;

import com.spring.model.User;
import com.spring.utils.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDetailsDao {

    private static final String SELECT_USER = "SELECT * FROM users WHERE username=?";
    private static final String SELECT_ROLES = "SELECT * FROM authorities WHERE username=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public  User findUserByName(String name){
       User user = jdbcTemplate.queryForObject(SELECT_USER, new Object[]{name},new UserRowMapper());
       if(user == null)
       {
           throw new RuntimeException("invalid user");
       }
       List<String> roles = jdbcTemplate.query(SELECT_ROLES, new Object[]{name}, new UserRolesMapper());
       user.setRoles(roles.toArray(new String[roles.size()]));
       return user;
    }



//    private static final class UserRowMapper implements RowMapper<User>
//    {
//        @Override
//        public User mapRow(ResultSet resultSet, int i) throws SQLException {
//            return null;
//        }
//    }



    private static final class UserRolesMapper implements RowMapper<String>
    {
        @Override
        public String mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getString("authority");
        }
    }
}
