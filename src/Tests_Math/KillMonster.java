package Tests_Math;

import java.util.Scanner;

public class KillMonster {
	int n, b[], cur;

	public KillMonster() {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			n = s.nextInt();
			cur = s.nextInt();
			b = new int[n];
			for (int i = 0; i < n; i++) {
				b[i] = s.nextInt();
				if (b[i] <= cur)
					cur += b[i];
				else
					cur += xymod(cur, b[i]);
			}
			System.out.println(cur);

		}
	}

	public static int xymod(int a, int b) {
		if (a < b) {
			int temp;
			temp = a;
			a = b;
			b = temp;
		}
		if (0 == b) {
			return a;
		}
		return xymod(a - b, b);
	}

}
