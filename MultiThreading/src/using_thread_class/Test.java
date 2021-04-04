package using_thread_class;

public class Test extends Thread
{
	public void run()
	{
		for(int i=0; i<3; i++)
		{
			System.out.println("A");
		}
	}

	public static void main(String[] args) throws InterruptedException 
	{
		Test t = new Test();
		Test1 t1 = new Test1();
		Thread.sleep(1000);
		t.start();
		Thread.sleep(1000);
		t1.start();
	}

}

class Test1 extends Thread
{
	public void run()
	{
		for(int i=0; i<3; i++)
		{
			System.out.println("B");
		}
	}
}
