package hust.soict.dsai.Lab01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CalculateDays {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = 1;
		int year = 0;
		
		//Year's input
		while(n>0) {
			System.out.println("Choose a year");
			year = sc.nextInt();
			if (year<=0) {
				System.out.println("Year must be a non-negative number or not equal to 0, please try again");
				n = 1;
			}
			else n = 0;
		}
		
		//this array is used for checking the month
		String[] months = {"123", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		List<String> listOfMonths = Arrays.asList(months);
		
		//Month's input
		int month = 0;
		int k = 1;
		while (k>0) {
			System.out.println("Choose a month");
			String m = sc.next();
			if (m.length() < 3) {
				month = Integer.parseInt(m);
				if (month > 0 && month <= 12) {
					k = 0;
				} else System.out.println("A month must be > 0 and <= 12");
			}
			
			else {
				month = listOfMonths.indexOf(m.substring(0, 3));
				if (month == -1) System.out.println("Invalid value, try again");
				else k = 0;
			}
		}
		
		//check number of days in a month
		
		//Check months after August
		if (month >= 8 && month % 2 == 0) {
			System.out.println("There are 31 days");
		}
		else if (month >= 8 && month % 2 != 0) {
			System.out.println("There are 30 days");
		}
		
		//Check months before August
		else if (month < 8 && month % 2 != 0) {
			System.out.println("There are 31 days");
		}
		else if (month < 8 && month % 2 ==0 && month != 2) {
			System.out.println("There are 30 days");
		}
		
		//Check if that is a leap year
		else if (month == 2) {
			if (year % 4 == 0) {
				if (year % 100 == 0 && year  % 400 != 0) {
					System.out.println("There are 28 days");
				} else System.out.println("There are 29 days");
			}
			else System.out.println("There are 28 days");
		}
	}
}
