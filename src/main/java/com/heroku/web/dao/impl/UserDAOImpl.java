/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroku.web.dao.impl;

import com.heroku.web.dao.UserDAO;
import com.heroku.web.entity.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class UserDAOImpl implements UserDAO {

    public User login(String userName, String password) throws ClassNotFoundException, SQLException {
        User user=null;
        Class.forName("org.postgresql.Driver");
            String dbuser="dypwvfxkbgwqhc";
            String pass="4e9ff6411dccbd5af627bf19ba87b1f6ec8a75ba0d186ef9287a1b9c9f965b98";
            String url="jdbc:postgresql://ec2-23-23-130-158.compute-1.amazonaws.com/d9spd1v2cea4nt?sslmode=require";
            Connection conn=DriverManager
                    .getConnection(url,dbuser,pass);
            //String sql="insert into skills(skill_name) values('Programming')";
            String sql="select * from users where username=? and password=?";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, userName);
            stmt.setString(2, password);
            //int result=stmt.executeUpdate();
            //System.out.println(result);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setStatus(rs.getBoolean("status"));
            }
            conn.close();
            return user;
    }
    
}
