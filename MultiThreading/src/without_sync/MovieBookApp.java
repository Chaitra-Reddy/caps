package without_sync;

public class MovieBookApp extends Thread
{
	static BookTheaterSeat b;
	int seats;
	
	public void run()
	{
		b.bookSeat(seats);
	}

	public static void main(String[] args) 
	{
		b = new BookTheaterSeat();
		
		MovieBookApp scott = new MovieBookApp();
		scott.seats = 7;
		scott.start();
		
		MovieBookApp jim = new MovieBookApp();
		jim.seats = 6;
		jim.start();
	}

}

class BookTheaterSeat
{
	int total_seats = 10;
	void bookSeat(int seats)
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
