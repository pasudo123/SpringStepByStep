package step.five;

import java.sql.SQLException;

public class NConnectionMaker implements ConnectionMaker{

	@Override
	public void makeConnection() throws ClassNotFoundException, SQLException {
		// N사 독자적인 방법으로 커넥션 객체 생성
	}

}
