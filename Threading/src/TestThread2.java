class Addition
{
	int n1,n2,add;
	public Addition(int n1,int n2) {
		this.n1=n1;
		this.n2=n2;
	}
	void calculate(){
		int add=n1+n2;
		System.out.println("Add is :"+add);
	}
}
class Demo1 implements Runnable
{
	Addition a;//new Addition();
	public Demo1(Addition a){
		
		this.a=a;
		/*Thread t=new Thread(this);
		t.start();*/
		new Thread(this).start();
	}
	public void run(){
		System.out.println("Thread is Running....");
		a.calculate();
	}

}
public class TestThread2 {
	public static void main(String[] args) {
		Addition a=new Addition(10,20);
		Demo1 d1=new Demo1(a);//create...
		System.out.println("Thank you...");		
	}
}

