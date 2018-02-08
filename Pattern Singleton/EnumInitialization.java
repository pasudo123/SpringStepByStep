package pattern.singleton;

// enum 살피기.
public enum EnumInitialization {
	INSTANCE;
	static String test = "";
	
	public static EnumInitialization getInstance(){
		test = "test";
		return INSTANCE;
	}
	
	/**
	 * 
	 * enum 이 sigleton pattern 으로 사용될 수 있는 이유는 아래와 같다.
	 * (1) INSTANCE 가 생성될 때, multi thread 로 부터 안전하다. 
	 * (추가된 method 들은 safety 하지 않을 수 있다.)
	 * (2) 단 한번의 인스턴스 생성을 보장한다.
	 * (3) 사용이 간편하다.
	 * (4) enum value 는 자바 프로그램 전역에서 접근이 가능하다.
	 * 
	 * **/
}
