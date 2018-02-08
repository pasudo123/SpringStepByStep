package step.one;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class UserDAO {
	public void add(User user) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daum", "doubler", "doublerpass");
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO USERS_TB (id, name, password) VALUES (?, ?, ?)");
		
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daum", "doubler", "doublerpass");
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
}
