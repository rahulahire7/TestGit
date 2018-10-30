class Thread11
{
	synchronized void call()
	{
		System.out.println("first statement");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
		System.out.println("second statement");
	}
}
class Thread2 extends Thread
{
	Thread11 t;
	public Thread2(Thread11 t)
	{
		this.t = t;
	}
	public void run()
	{
		t.call();
	}
}
public class SynchronizedThreads
{
	public static void main(String args[])
	{
		Thread11 obj1 = new Thread11();
		Thread2 Obja = new Thread2(obj1);
		Thread2 Objb = new Thread2(obj1);
		Obja.start();
		Objb.start();
	}
}