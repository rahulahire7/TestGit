class Demo extends Thread
{
	int n1,n2,add;
	public Demo(int n1,int n2){
		this.n1=n1;
		this.n2=n2;
	}
	public void run(){
		System.out.println("Thread is Running....");
		calculate();
	}
	void calculate(){
		add=n1+n2;
		System.out.println("Add is :"+add);
	}
}
public class TestThread1 {
	public static void main(String[] args) {
		Demo d1=new Demo(10,20);//create...
		d1.start();//Runnable...
		d1.setDaemon(true);
		System.gc();
		System.out.println("Thank you...");		
	}
}

