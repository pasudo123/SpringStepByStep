package step.four;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * step.three 애 있던 DB 커넥션을 가져오는 메소드를 아예
 * 클래스로 분리하였다. 상속관계가 아닌 독립적인 클래스로 만듦*/
public class SimpleConnectionMaker {
	public Connection makeNewConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daum", "doubler", "doublerpass");
		
		return conn;
	}
		
	/**********************************************
	 * 
	 * 아래에 있는 코드 전체를 해당 클래스에서 다시 구현해야 한다. 
	 * 결과적으로 메소드를 두 개의 형태로 나누어야 한다는 말.
	 * 하지만 DB 커넥션읙 객체가 여러개라면 모든 메소드를 
	 * 하나하나 다 작업해주어야 한다. 이 때 해결할 수 있는 방법 
	 * 
	 * interface 이다.
	 * 
	 **********************************************/
	
//	public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
//	
//	/**
//	 * 슈퍼클래스에 기본적인 로직의 흐름을 만들고, 그 기능의 일부를 
//	 * 추상 메소드 혹은 오버라이딩이 가능한 protected 메소드 등으로 만든 뒤, 
//	 * 서브 클래스에서 이런 메소드를 필요에 맞게 구현한 것
//	 * 
//	 * : 템플릿 메소드 패턴
//	 * **/
//	
//	// 서브클래스에서 구체적인 오브젝트 생성 방법을 결정 : 팩토리 메소드 패턴
//	public class NUserDao extends UserDAO{
//		@Override
//		public Connection getConnection() throws ClassNotFoundException, SQLException {
//			// N 사에서 요청한 DB 커넥션 객체 반환
//			return null;
//		}
//	}
//	
//	// 서브클래스에서 구체적인 오브젝트 생성 방법을 결정 : 팩토리 메소드 패턴
//	public class DUserDao extends UserDAO{
//		@Override
//		public Connection getConnection() throws ClassNotFoundException, SQLException {
//			// D 사에서 요청한  DB 커넥션 객체 반환
//			return null;
//		}
//	}
}
