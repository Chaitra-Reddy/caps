package with_inter_thread_comm;

public class MovieBookApp 
{

	public static void main(String[] args) throws InterruptedException 
	{
		TotalEarnings te = new TotalEarnings();
		te.start();
		
		synchronized(te)
		{
			te.wait();
			System.out.println("Total earning: $" + te.total);
		}
	}

}

class TotalEarnings extends Thread
{
	int total = 0;
	public void run()
	{
		synchronized(this)
		{
			for(int i=0; i<10; i++)
			{
				total += 100;
			}
			this.notify();
		}
		
	}
}

//================================================================================

//public class MovieBookApp 
//{
//
//	public static void main(String[] args) 
//	{
//		TotalEarnings te = new TotalEarnings();
//		te.start();
//		System.out.println("Total earning: $" + te.total);
//	}
//
//}
//
//class TotalEarnings extends Thread
//{
//	int total = 0;
//	public void run()
//	{
//		for(int i=0; i<10; i++)
//		{
//			total += 100;
//		}
//	}
//}
