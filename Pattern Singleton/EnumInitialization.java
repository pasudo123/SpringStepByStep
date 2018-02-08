package pattern.singleton;

// enum 살피기.
public enum EnumInitialization {
	INSTANCE;
	static String test = "";
	
	public static EnumInitialization getInstance(){
		test = "test";
		return INSTANCE;
	}
}
