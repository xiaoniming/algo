package NowCoder;

import java.util.Scanner;

public class Tencent_move_capitals {

	public static void main(String[] args) {
		readData();

	}

	public static void readData() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string = scanner.next();
			System.out.println(moveCaptials(string));
		}
		scanner.close();
	}

	public static String moveCaptials(String s) {
		if (s == null || s.length() == 0)
			return "";
		char[] cs = s.toCharArray();
		char temp;
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = 0; j < s.length() - 1 - i; j++) {
				if (cmp(cs[j], cs[j + 1])) {
					temp = cs[j + 1];
					cs[j + 1] = cs[j];
					cs[j] = temp;
				}
			}
		}
		return String.valueOf(cs);
	}

	public static boolean cmp(char a, char b) {
		if (a <= 'Z' && b >= 'a')
			return true;
		else
			return false;
	}
}
