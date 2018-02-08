package pattern.singleton;

public class ThreadSafeInitialization {
	private static ThreadSafeInitialization instance;
	
	private ThreadSafeInitialization(){}
	
	// 멀티스레드 문제를 해결하기 위해 동기화 처리
	// 여기서 많은 스레드들이 getInstance() 를 호출하게 되면 높은 cost 발생 ㅡ> 성능저하
	public static synchronized ThreadSafeInitialization getInstance(){
		if(instance == null)
			instance = new ThreadSafeInitialization();
		
		return instance;
	}
	
	public void print () {
		System.out.println("It's print() method in ThreadSafeInitalization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
	}
}
