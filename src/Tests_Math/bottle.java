package Tests_Math;

import java.util.Scanner;

public class bottle {

	public void bottle() {

		int n[] = new int[10];
		Scanner c = new Scanner(System.in);
		int i = 0;
		while (c.hasNext()) {
			n[i] = c.nextInt();
			if (n[i] == 0)
				break;
			i++;
		}

		for (int j = 0; j < i; j++) {
			countBottle(n[j]);
		}
		c.close();

	}

	public static void countBottle(int n) {
		int empty = n, sum = 0;
		while (empty / 3 != 0) {
			sum += empty / 3;
			empty = empty / 3 + empty % 3;
		}

		if (empty == 2)
			sum += 1;
		System.out.println(sum);

	}

}
