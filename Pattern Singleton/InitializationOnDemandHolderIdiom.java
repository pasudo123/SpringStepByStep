package pattern.singleton;

/**
 * 
 * 
 * JVM 의 class Loader의 매커니즘과 class의 load 시점을 이용하여
 * 내부 클래스를 생성시킴으로 thread 간의 동기화 문제를 해결한다.
 * 
 * **/
public class InitializationOnDemandHolderIdiom {
	
	private InitializationOnDemandHolderIdiom(){}
	
	private static class Singleton{
		private static final InitializationOnDemandHolderIdiom instance = new InitializationOnDemandHolderIdiom();
	}
	
	public static InitializationOnDemandHolderIdiom getInstance(){
		System.out.println("create instance");
		return Singleton.instance;
	}
}
