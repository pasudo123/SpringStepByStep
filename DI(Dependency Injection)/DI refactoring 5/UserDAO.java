package step.five;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private ConnectionMaker connectionMaker;
	
	public UserDAO(){
		/********************************************************
		 */
		
		// 초기에 한번 어떤 디비 커넥션을 사용할 지 결정된다. 
		// 클래스의 이름을 넣어서 오브젝트를 만들지 않으면 어떻게 접근하는 것이 좋은가?
		connectionMaker = new DConnectionMaker();
		
		/**
		 ********************************************************/
	}
	
//	public void add(User user) throws ClassNotFoundException, SQLException{
//		Connection conn = simpleConnectionMaker.makeNewConnection();
//		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO USERS_TB (id, name, password) VALUES (?, ?, ?)");
//		
//		pstmt.setString(1, user.getId());
//		pstmt.setString(2, user.getName());
//		pstmt.setString(3, user.getPassword());
//		
//		pstmt.executeUpdate();
//		
//		pstmt.close();
//		conn.close();
//	}
	
//	public User get(String id) throws ClassNotFoundException, SQLException{
//		Connection conn = simpleConnectionMaker.makeNewConnection();
//		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USERS_TB WHERE id = ?");
//		
//		pstmt.setString(1, id);
//		
//		ResultSet rs = pstmt.executeQuery();
//		User user = new User();
//		
//		rs.next();
//		user.setId(rs.getString("id"));
//		user.setName(rs.getString("name"));
//		user.setPassword(rs.getString("password"));
//		
//		rs.close();
//		pstmt.close();
//		conn.close();
//		
//		return user;
//	}
}