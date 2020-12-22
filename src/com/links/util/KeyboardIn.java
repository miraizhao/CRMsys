package com.links.util;

import java.util.Scanner;

public class KeyboardIn {
	public static String InPut() {
		Scanner scanner=new Scanner(System.in);
		String string=scanner.next();
		return string;
	}
	public static float floatInPut() {
		Scanner scanner=new Scanner(System.in);
		float f=scanner.nextFloat();
		return f;
	}
	public static int INTInPut() {
		Scanner scanner=new Scanner(System.in);
		int f=scanner.nextInt();
		return f;
	}
}
