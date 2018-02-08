package step.four;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private SimpleConnectionMaker simpleConnectionMaker;
	
	public UserDAO(){
		simpleConnectionMaker = new SimpleConnectionMaker();
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException{
		Connection conn = simpleConnectionMaker.makeNewConnection();
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO USERS_TB (id, name, password) VALUES (?, ?, ?)");
		
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException{
		Connection conn = simpleConnectionMaker.makeNewConnection();
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