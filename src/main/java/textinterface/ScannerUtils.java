package textinterface;

import java.util.Scanner;

public class ScannerUtils {
	public static Scanner sc = new Scanner(System.in);

	public static int getInt() {
		int input = 0;
		while (sc.hasNextInt() == false) {
			System.out.println("Opcao inválida");
			sc.next();
		}
		input = sc.nextInt();
		sc.nextLine();
		return input;
	}

	public int getInt(String msg) {
		System.out.println(msg);
		return getInt();
	}
	public int getInt(String msg, int min, int max) {
		int input = 0;
		String errorMsg = "O numero nao Ã© vÃ¡lido.Insira um nÃºmero de 1 a 50";
		do {
			input = getInt(msg);
			if (input < min || input > max) {
				System.out.println(errorMsg);
			}
		} while (input < min || input > max);
		return input;

	}

	public int getInt(String msg, int[] values) {
		int input = 0;
		input = getInt(msg);
		boolean check = false;

		for (int i = 0; i < values.length; i++) {
			int j = values[i];
			if (j == input) {
				check = true;
			}
		}
		if (check) {
			return input;
		} else {
			System.out.println("erro");
			return getInt(msg, values);
		}

	}

	public static String getString(String msg) {
		
		String input = "";
		System.out.println(msg);
		input = sc.nextLine();
		return input;
	}

}
