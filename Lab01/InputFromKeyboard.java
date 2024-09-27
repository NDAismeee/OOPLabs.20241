package javabasic;

import java.util.Scanner;

public class InputFromKeyboard {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What's your name?");
		String strName = sc.nextLine();
		
		System.out.println("How old are you?");
		int age = sc.nextInt();
		
		System.out.println("How tall are you(m)?");
		double dHeight = sc.nextDouble();
		
		System.out.println("Mr/Ms. " + strName + ", " + age + " years old. " + "Your height is: " + dHeight +"m.");
	}
}
