package step.six;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
	/**
	 * 
	 * 두개의 클래스가 서로 긴밀하게 연결되어 있지 않도록 
	 * 두개의 클래스가 서로 느슨하게 연결되어 질수 있도록
	 * 
	 * 인터페이스 이용
	 * 
	 * **/

	// DB 커넥션을 N사 그리고 D사에 대해서 각각의 객체를 만들 필요 없이
	// 인터페이스 구현체 하나로 N사 그리고 D사에 대한 DB 커넥션 객체를 호출 할 수 있다.
	// 이것이 인터페이스 구현체를 이용하는 가장 큰 이유
	public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
