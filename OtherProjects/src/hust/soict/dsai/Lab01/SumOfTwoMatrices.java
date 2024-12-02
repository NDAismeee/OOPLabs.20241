package hust.soict.dsai.Lab01;

import java.util.Scanner;

public class SumOfTwoMatrices {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Choose the number of rows: ");
		int r = sc.nextInt();
		
		System.out.print("Choose the number of columns: ");
		int c = sc.nextInt();
		
		int[][] m1 = new int[r][c];
		int[][] m2 = new int[r][c];
		
		System.out.println("Input matrix 1: ");
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				System.out.print("a"+ (i+1) + (j+1)+ " = ");
				m1[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Input matrix 2: ");
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				System.out.print("b"+ (i+1) + (j+1)+ " = ");
				m2[i][j] = sc.nextInt();
			}
		}
		
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				System.out.print((m1[i][j] + m2[i][j]) + " ");
			}
			System.out.println(" ");
		}
	}
}
