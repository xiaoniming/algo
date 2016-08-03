

import java.util.Scanner;
import java.util.TreeSet;

public class A_ReadDataSummary {

	public static void main(String[] args) {
		A_ReadDataSummary exp = new A_ReadDataSummary();
		exp.wordNumNoRepeat();

	}

	public void wordNumNoRepeat() {
		TreeSet<String> set = new TreeSet<String>();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string = scanner.next();
			set.add(string);
			;
		}
		System.out.println(set.size());
		scanner.close();
	}

}
