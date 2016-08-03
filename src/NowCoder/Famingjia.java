package NowCoder;

import java.util.Scanner;

public class Famingjia {
	int R, x1, x2, x3, y1, y2, y3, x0, y0;

	public Famingjia() {
		readData();
		int maxDamage = isIn(x1, y1) + isIn(x2, y2) + isIn(x3, y3);
		System.out.println(maxDamage + "x");
	}

	private void readData() {
		System.out.println("Please enter 9 ints");
		Scanner s = new Scanner(System.in);
		while (s.hasNext())
			R = s.nextInt();
		x1 = s.nextInt();
		y1 = s.nextInt();
		x2 = s.nextInt();
		y2 = s.nextInt();
		x3 = s.nextInt();
		y3 = s.nextInt();
		x0 = s.nextInt();
		y0 = s.nextInt();

	}

	private int isIn(int x, int y) {
		if ((x0 - x) * (x0 - x) + (y0 - y) * (y0 - y) <= R * R)
			return 1;
		else
			return 0;
	}

}
