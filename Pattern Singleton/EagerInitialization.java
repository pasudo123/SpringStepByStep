package pattern.singleton;

public class EagerInitialization {
	
	// private static 으로 전역변수 초기화
	// EagerInitialization.instance 로 접근 불가
	private static EagerInitialization instance = new EagerInitialization();
	
	// 인스턴스가 private 으로 선언. 생성자도 private
	private EagerInitialization(){
		System.out.println("Call EagerInitialization Constructor");
	}
	
	// 외부 클래스에서 EagerInitialization 클래스의 인스턴스를 가질 수 있는 유일한 방법이다.
	public static EagerInitialization getInstance(){
		return instance;
	}
	
	public void print(){
		System.out.println("It's print() method in EagerInitialization instance");
		System.out.println("instance hashCode > " + instance.hashCode());
	}
	
	public static void main(String[]args){
		A a = new A();
		a.instance = getInstance();
		
		B b = new B();
		b.instance = getInstance();
		
		C c = new C();
		c.instance = getInstance();
		
		D d = new D();
		d.instance = getInstance();
	}
}

class A{
	EagerInitialization instance = null;
}

class B{
	EagerInitialization instance = null;
}

class C{
	EagerInitialization instance = null;
}

class D{
	EagerInitialization instance = null;
}