package NowCoder;

import java.util.Scanner;

public class NetEase_fahzuanji {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int s = scanner.nextInt();
		int L = scanner.nextInt();

		int per = (L + 1) / (s + 1);
		per = per % 13 == 0 ? (per - 1) : per;
		int num = n / per;
		int rest = n % per;
		if (num != 0 && rest != 0) {
			num++;
			if (rest % 13 == 0) {
				num++;
				if ((rest + 1) <= per && (per - 1) % 13 != 0)
					num--;
				else if ((rest + 2) <= per && (per - 2) % 13 != 0)
					num--;
			}
		}
		if (num == 0) {
			num = n % 13 == 0 ? 2 : 1;
		}
		System.out.println(num);
	}

}
