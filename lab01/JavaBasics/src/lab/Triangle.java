package lab;
import java.util.Scanner;
public class Triangle {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("value of n is: ");
		int n = keyboard.nextInt();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n - 1 - i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < 2 * i + 1; k++) {
				System.out.print("*");
			}
			for(int j = 0; j < n - 1 - i; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		
		keyboard.close();
	}
}
