/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * Tất cả các file DAL khác sẽ kế thừa class DBConnect và sử dụng luôn biến conn mà không cần phải khởi tạo lại
 */
public class DBConnect {
    protected Connection conn;
    
    public DBConnect(){
        final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	final String user = "QLTTAV";
	final String password = "QLTTAV";
	try {
            conn = DriverManager.getConnection(url,user,password);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
    }
}
