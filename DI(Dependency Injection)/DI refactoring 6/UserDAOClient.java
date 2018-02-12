package step.six;

import java.sql.SQLException;

public class UserDAOClient {
	private static UserDAO userDao;

	public static void main(String[]args) throws ClassNotFoundException, SQLException{
		
		// UserDAOClient가 Connection에 대한 책임을 갖고
		// UserDAO는 그 책임에서 분리시킨다.
		
		// UserDAO가 사용할 ConnectionMaker 구현 클래스를 결정할 수 있다.
		ConnectionMaker connectionMaker = new DConnectionMaker();
//		ConnectionMaker connectionMaker = new NConnectionMaker();
		
		userDao = new UserDAO(connectionMaker);
	}
}
