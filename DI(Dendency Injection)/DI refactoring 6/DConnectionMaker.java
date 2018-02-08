package step.six;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker{

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		// D사 독자적인 방법으로 커넥션 객체 생성
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daum", "doubler", "doublerpass");
		
		return conn;
	}

}
