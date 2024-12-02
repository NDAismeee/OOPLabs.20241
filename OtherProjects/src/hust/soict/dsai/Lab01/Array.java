package hust.soict.dsai.Lab01;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the size of the array");
		int n = sc.nextInt();
		int[] nums = new int[n];
		
		for (int i=0; i<n; i++) {
			System.out.print("a"+ (i+1) + " = ");
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		int sum = 0;
		for (int i=0; i<n; i++) {
			sum += nums[i];
		}
		int average = sum/n;
		
		System.out.println("Array after sorting: " + Arrays.toString(nums));
		System.out.println("Sum of the array: " + sum);
		System.out.println("Average of the array: " + average);
	}
}
