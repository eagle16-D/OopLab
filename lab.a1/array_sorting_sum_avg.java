package lab.a1;

import java.util.Arrays;
import java.util.Scanner;

public class array_sorting_sum_avg {
	private int arr[];
	
	public void sort() {
		//insertion-sort algorithm
		for(int i = 1; i < arr.length; i++) {
			int j = i;
			int last = arr[i];
			while(j > 0 && arr[j-1] > last) {
				arr[j] = arr[j-1];
				j -= 1;
			}
			arr[j] = last;
		}
	}
		
	public int sum() {
		//cal the sum
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	public int average() {
		// cal the avg
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		int avg = sum / arr.length;
		return avg;
	}
	public static void main(String[] args) {
		array_sorting_sum_avg arr1 = new array_sorting_sum_avg();
		Scanner sc = new Scanner(System.in);
		arr1.arr = new int[5];
		for(int i = 0; i < 5; i++) {
			arr1.arr[i] = sc.nextInt();
		}
		
		Arrays.toString(arr1.arr);
		arr1.sort();
		
		//print array
		for(int i = 0; i < arr1.arr.length; i++) {
			System.out.print(arr1.arr[i] + " ");
		}
		System.out.println();
		
		//print sum
		System.out.println("the sum of array is " + arr1.sum());
		
		//print avg
		System.out.println("the average of array is " + arr1.average());
	}
	
}


	
	
