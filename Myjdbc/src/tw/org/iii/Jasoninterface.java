package tw.org.iii;

public class Jasoninterface {

	public static void main(String[] args) {
		p1 obj = new Brad011();
//		Brad011 obj2 =(Brad011) obj;
//		obj2.m2();
		//main2(obj1);
	}
	static void main2(p1 anyobj){
		anyobj.m1();
		if (anyobj instanceof Brad011){
			((Brad011)anyobj).m3();
		}else if (anyobj instanceof Brad012){
			((Brad012)anyobj).m4();
		}
	}

}
interface p1{
	void m1();
}
class Brad011 implements p1{
	public void m1(){System.out.println("A");}
	void m3 (){}
}
class Brad012 implements p1{
	public void m1(){System.out.println("B");}
	void m4 (){}
}