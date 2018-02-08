package pattern.singleton;

public class ObjectPartner {
	private static ObjectPartner instance = null;
	
	private ObjectPartner(){}
	
	public static ObjectPartner getInstance(){
		if(instance == null)
			instance = new ObjectPartner();
		return instance;
	}
	
	public void print(){
		System.out.println("Hello World");
	}
	
	public static void main(String[]args){
		Test t = new Test();
		t.create();
	}
}

class Test{
	public void create(){
		ObjectPartner instance = ObjectPartner.getInstance();
		instance.print();
	}
}
