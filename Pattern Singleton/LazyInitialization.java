package pattern.singleton;

public class LazyInitialization {
	private static LazyInitialization instance;
	private LazyInitialization(){}
	
	// 클래스 인스턴스가 사용되는 시점에 인스턴스를 생성
	public static LazyInitialization getInstance(){
		if(instance == null)
			instance = new LazyInitialization();
		
		return instance;
	}
	
	public void print () {
		System.out.println("It's print() method in LazyInitialization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}
}
