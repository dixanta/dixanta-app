/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroku.web.dao;

import com.heroku.web.entity.User;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public interface UserDAO {
    User login(String userName,String password)
            throws ClassNotFoundException,SQLException;
}
