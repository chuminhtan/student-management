/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Tất cả các file DAL khác sẽ kế thừa class DBConnect và sử dụng luôn biến conn
 * mà không cần phải khởi tạo lại
 */
public class DBConnect {

    protected Connection conn;

    public DBConnect() {
        final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        final String user = "quanly";
        final String password = "1234";
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
//            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
