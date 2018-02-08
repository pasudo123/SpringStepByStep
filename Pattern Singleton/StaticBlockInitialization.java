package pattern.singleton;

public class StaticBlockInitialization {
	
	private static StaticBlockInitialization instance;
	
	// 생성자
	private StaticBlockInitialization(){}
	
	// 클래스가 로딩될 때 최초 1번 실행
	static{
		try{
			System.out.println("instance create .. ");
			instance = new StaticBlockInitialization();
		}
		catch(Exception e){
			throw new RuntimeException("Exception creating StaticBlockInitialization instance.");
		}
	}
	
	public static StaticBlockInitialization getInstance(){
		return instance;
	}
	
	public void print(){
		System.out.println("It's print() method in StaticBlockInitalization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}
	
}
