package with_static_sync;

public class MovieBookApp extends Thread
{
	public static void main(String[] args) 
	{
		BookTheaterSeat b1 = new BookTheaterSeat();
		
		MyThread1 t1 = new MyThread1(b1,7);
		t1.start();
		
		MyThread2 t2 = new MyThread2(b1,6);
		t2.start();
		
		//================================
		
		BookTheaterSeat b2 = new BookTheaterSeat();
		
		MyThread1 t3 = new MyThread1(b2,7);
		t3.start();
		
		MyThread2 t4 = new MyThread2(b2,6);
		t4.start();
	}
}

class BookTheaterSeat
{
	static int total_seats = 20;
	synchronized static void bookSeat(int seats)
	{
		if(total_seats >= seats)
		{
			System.out.println(seats + " seats booked succesfully!");
			total_seats = total_seats - seats;
			System.out.println("Seats left: " + total_seats);
		}
		else
		{
			System.out.println("Sorry seats cannot be booked..");
			System.out.println("Seats left: " + total_seats);
		}
	}
}

class MyThread1 extends Thread
{
	BookTheaterSeat b;
	int seats;
	MyThread1(BookTheaterSeat b, int seats)
	{
		this.b = b;
		this.seats = seats;
	}
	public void run()
	{
		b.bookSeat(seats);
	}
}

class MyThread2 extends Thread
{
	BookTheaterSeat b;
	int seats;
	MyThread2(BookTheaterSeat b, int seats)
	{
		this.b = b;
		this.seats = seats;
	}
	public void run()
	{
		b.bookSeat(seats);
	}
}
