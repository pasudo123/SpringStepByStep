package step.two;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class UserDAO {
	public void add(User user) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO USERS_TB (id, name, password) VALUES (?, ?, ?)");
		
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USERS_TB WHERE id = ?");
		
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		User user = new User();
		
		rs.next();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return user;
	}
	
	/*
	 * step.one 패키지에서 하던 것
	 * Connection 객체를 하나의 메소드에서 하나씩 구현하는 것을 따로 메소드를 분리시켰다.
	 * 중복된 코드를 하나의 메소드로 옮김*/
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daum", "doubler", "doublerpass");
		
		return conn;
	}
}
