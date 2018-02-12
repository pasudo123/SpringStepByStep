package step.two;

import java.sql.SQLException;

/**
 * Date : 2018. 01. 25
 * prgmr : PASUDO
 *
 * - DAO(Data Access Object) 만들기 1
 **/

public class Main {
	public static void main(String[]args) throws ClassNotFoundException, SQLException{
		UserDAO userDao = new UserDAO();
		
		User user = new User();
		user.setId("doubler");	// Mysql : PRIMARY KEY
		user.setName("쌍기역");
		user.setPassword("1004");
		
//		userDao.add(user);
		
		System.out.println(user.getId() + " 등록 성공");
		System.out.println("step.two ---");
		
		User user2 = userDao.get("doubler");
		
		System.out.println("Id : " + user2.getId());
		System.out.println("Name : " + user2.getName());
		System.out.println("PASS : " + user2.getPassword());
		
		/**
		 * 대규모 사용자가 들어왔을 경우에, 여기서 메인스레드에서 값을 집어넣어야 함
		 * 커넥션 객체가 변경되는 경우, UserDAO 클래스를 수정해야 함
		 * 
		 * -- 변화의 폭을 줄여주는 것.
		 * 분리와 확장을 한다.
		 * **/
	}
}
