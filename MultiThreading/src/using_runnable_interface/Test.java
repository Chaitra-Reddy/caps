package using_runnable_interface;

public class Test implements Runnable
{

	public static void main(String[] args) 
	{
		Test t = new Test();
		Thread th = new Thread(t);
		th.start();
	}

	@Override
	public void run() 
	{
		System.out.println("thread..");
	}

}
