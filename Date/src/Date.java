
public class Date {

	int month;
	int day;
	int year;
	
	Date( int m, int d, int y)
	{
		this.month = m;
		this.day = d;
		this.year = y;
	}
	
	int getMonth() { return month;}
	int getDay() {return day;}
	int getYear() { return year; }
	
	void setMonth(int m) { this.month = m; }
	void setDay(int d) { this.day = d; }
	void setYear(int y) { this.year = y; }
	
	void DisplayDate() 
	{
		System.out.printf("The date is %d/%d/%d\n",month, day,year);
	}

}
