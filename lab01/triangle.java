<<<<<<< HEAD
package lab1;
=======
package lab01;
>>>>>>> 5b8f20e33920b944e220cf0f81058f92b741fdae
import java.util.Scanner;
public class triangle {
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
