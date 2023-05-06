package lab1;

import java.time.*;
import java.util.Scanner;

public class num_of_days {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Year? ");
		int year = keyboard.nextInt();
		
		// handle negavtive year
		try {
		    if (year < 0) {
		        throw new IllegalArgumentException("Year must be a non-negative number.");
		    }
		} catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		}
		
		if(year >= 0) {
			//import input from keyboard
			Scanner scanner = new Scanner(System.in);
			System.out.println("Month? ");
			String input = scanner.nextLine().trim();

			int monthNumber = -1;
			
			//set format of month to integer
			switch (input.toLowerCase()) {
			case "january":
			case "jan.":
			case "jan":
			case "1":
				monthNumber = 1;
				break;
			case "february":
			case "feb.":
			case "feb":
			case "2":
				monthNumber = 2;
				break;
			case "march":
			case "mar.":
			case "mar":
			case "3":
				monthNumber = 3;
				break;
			case "april":
			case "apr.":
			case "apr":
			case "4":
				monthNumber = 4;
				break;
            case "may":
            case "5":
                monthNumber = 5;
                break;
            case "june":
            case "jun":
            case "jun.":
            case "6":
                monthNumber = 6;
                break;
            case "july":
            case "jul":
            case "7":
                monthNumber = 7;
                break;
            case "august":
            case "aug":
            case "aug.":
            case "8":
                monthNumber = 8;
                break;
            case "september":
            case "sep":
            case "sept.":
            case "9":
                monthNumber = 9;
                break;
            case "october":
            case "oct":
            case "oct.":
            case "10":
                monthNumber = 10;
                break;
            case "november":
            case "nov":
            case "nov.":
            case "11":
                monthNumber = 11;
                break;
            case "december":
            case "dec":
            case "dec.":
            case "12":
                monthNumber = 12;
                break;
            default:
                System.out.println("Invalid month entered.");
                System.exit(0);
			}
			
			YearMonth yearMonth = YearMonth.of(year, monthNumber);
			int daysInMonth = yearMonth.lengthOfMonth();
		
			System.out.println("Number of days is " + daysInMonth);
		}
	}
}
