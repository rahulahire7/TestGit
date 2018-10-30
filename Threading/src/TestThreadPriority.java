class Demo3 extends Thread{
	private String str;
	public Demo3(String str){
		this.str=str;
	}
	public void run(){
		for(int i=1;i<=5;i++){
			System.out.println(str+" "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class TestThreadPriority {
	public static void main(String[] args) {
		Demo3 t1=new Demo3("java");
		Demo3 t2=new Demo3("oracle");
		
		t1.start();
		t2.start();
		
		t1.setName("JAVA");
		t2.setName("Oracle");
		
		t1.setPriority(Thread.MIN_PRIORITY+2);//3
		t2.setPriority(Thread.MAX_PRIORITY-1);//9
		
		for(int i=1;i<=3;i++){
			System.out.println("In Mian :"+i);
			
			/*try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			/*try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
	}

}
