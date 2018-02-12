package step.three;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public abstract class UserDAO {
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
	 * step.two 에서 같은 클래스에 다른 메소드로 분리되었던 DB 커넥션 연결에 대해서
	 * 상속을 통해 서브클래스로 분리하였다.
	 * 
	 * 여기서 문제점이 발생한다.
	 * 해당 클래스, UserDAO가 다른 클래스를 상속하고 있다면 
	 * 다른 목적으로 UserDAO를 상속하기 어려워진다.
	 * 다른 추상메소드를 모두 오버라이딩 해야하기 때문.
	 * */
	public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
	
	/**
	 * 슈퍼클래스에 기본적인 로직의 흐름을 만들고, 그 기능의 일부를 
	 * 추상 메소드 혹은 오버라이딩이 가능한 protected 메소드 등으로 만든 뒤, 
	 * 서브 클래스에서 이런 메소드를 필요에 맞게 구현한 것
	 * 
	 * : 템플릿 메소드 패턴
	 * **/
	
	// 서브클래스에서 구체적인 오브젝트 생성 방법을 결정 : 팩토리 메소드 패턴
	public class NUserDao extends UserDAO{
		@Override
		public Connection getConnection() throws ClassNotFoundException, SQLException {
			// N 사에서 요청한 DB 커넥션 객체 반환
			return null;
		}
	}
	
	// 서브클래스에서 구체적인 오브젝트 생성 방법을 결정 : 팩토리 메소드 패턴
	public class DUserDao extends UserDAO{
		@Override
		public Connection getConnection() throws ClassNotFoundException, SQLException {
			// D 사에서 요청한  DB 커넥션 객체 반환
			return null;
		}
	}
}