package common;

import java.util.Scanner;

public class ScannerUtil {
	private static Scanner scanner = new Scanner(System.in);
	
	private ScannerUtil() {}
	
	public static String nextLine() {
		return scanner.nextLine();
	}
	
	public static int nextInt() {
		try {
			return Integer.parseInt(scanner.nextLine());
		} catch(Exception e) {
			return -18;
		}
	}
	
	public static void close() {
		scanner.close();
	}
}
