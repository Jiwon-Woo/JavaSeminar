package date;

public class MyDate {
	
	int	day;
	int	month;
	int	year;
	boolean	leapYear;
	int	lastDay;
	
	public	MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.leapYear = this.isLeapYear();
		this.lastDay = this.lastDayOfMonth();
	}
	
	public boolean	isLeapYear() {
		boolean isLeapYear = false;
		
		if (this.year > 0 && this.year % 4 == 0) {
			isLeapYear = true;
			if (this.year % 100 == 0 && this.year % 400 != 0) {
				isLeapYear = false;
			}
		}
		return isLeapYear;
	}
	
	public int	lastDayOfMonth() {
		int[]	day31 = {1, 3, 5, 7, 8, 10, 12};
		
		if (this.month ==2) {
			if (this.leapYear == true) {
				return 29;
			}
			return 28;
		}
		for(int i = 0; i < 7; i++) {
			if (this.month == day31[i])
				return 31;
		}
		return 30;
	}
	
	public String	isValid() {
		int	valid = 1;
		
		if (this.year < 1) {
			valid = 0;
		}
		if (this.month < 1 || this.month > 12) {
			valid = 0;
		}
		if (this.day < 1 || this.day > this.lastDay) {
			valid = 0;
		}
		if (valid == 0) {
			return("유효하지 않은 날짜입니다.");
		}
		else {
			return("유효한 날짜입니다.");
		}
	}

}
